package edu.asu.ser515.team33.syllabusgenerator.util;

import edu.asu.ser515.team33.syllabusgenerator.scraper.WebContent;
import edu.asu.ser515.team33.syllabusgenerator.syllabus.College;
import edu.asu.ser515.team33.syllabusgenerator.syllabus.Section;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class ConfigUtil {

    private static final String CONFIG_FILE = "config.json";
    private static ConfigUtil INSTANCE;
    private final Map<String, List<Section>> templates;
    private final Set<College> colleges;
    private final Set<WebContent> scrapedWebContent;
    private String termsUrl;
    private String subjectsUrl;
    private String classesUrl;
    private String coursesUrl;
    private String peopleSearchUrl;

    private ConfigUtil() {
        templates = new HashMap<>();
        colleges = new HashSet<>();
        scrapedWebContent = new HashSet<>();
        this.initialize();
    }

    public static ConfigUtil getInstance() {
        ConfigUtil localRef = INSTANCE;
        if (localRef == null) {
            synchronized (ConfigUtil.class) {
                localRef = INSTANCE;
                if (localRef == null) {
                    INSTANCE = localRef = new ConfigUtil();
                }
            }
        }
        return localRef;
    }

    public Map<String, List<Section>> getTemplates() {
        return templates;
    }

    public Set<College> getColleges() {
        return colleges;
    }

    public Set<WebContent> getScrapedWebContent() {
        return scrapedWebContent;
    }

    public String getTermsUrl() {
        return termsUrl;
    }

    public String getSubjectsUrl() {
        return subjectsUrl;
    }

    public String getClassesUrl() {
        return classesUrl;
    }

    public String getCoursesUrl() {
        return coursesUrl;
    }

    public String getPeopleSearchUrl() {
        return peopleSearchUrl;
    }

    private void initialize() {
        InputStream inputStream = ConfigUtil.class.getClassLoader().getResourceAsStream(CONFIG_FILE);

        if (inputStream == null) {
            throw new RuntimeException("Could not locate the config file");
        }

        JSONTokener jsonTokener = new JSONTokener(inputStream);

        JSONObject universityJson = new JSONObject(jsonTokener);

        this.termsUrl = universityJson.getString("termsUrl");
        this.subjectsUrl = universityJson.getString("subjectsUrl");
        this.classesUrl = universityJson.getString("classesUrl");
        this.coursesUrl = universityJson.getString("coursesUrl");
        this.peopleSearchUrl = universityJson.getString("peopleSearchUrl");
        JSONArray collegesJson = universityJson.getJSONArray("colleges");

        for (int i = 0; i < collegesJson.length(); i++) {
            JSONObject collegeJson = collegesJson.getJSONObject(i);
            String collegeId = collegeJson.getString("id");
            String collegeName = collegeJson.getString("name");
            String templatePath = collegeJson.getString("templatePath");
            this.colleges.add(new College(collegeId, collegeName));

            try {
                this.populateTemplates(collegeId, templatePath);
            } catch(Exception e) {
                System.out.println("Issue with " + templatePath);
                throw new RuntimeException("Issue with template file " + templatePath, e);
            }
        }
    }

    private void populateTemplates(String collegeId, String templatePath) {
        InputStream inputStream = ConfigUtil.class.getClassLoader().getResourceAsStream(templatePath);

        if (inputStream == null) {
            throw new RuntimeException("Could not locate the template file: " + templatePath);
        }

        JSONTokener jsonTokener = new JSONTokener(inputStream);

        JSONObject templateJson = new JSONObject(jsonTokener);

        if (!collegeId.equals(templateJson.getString("id"))) {
            throw new RuntimeException("Mismatched configuration in config file and template file");
        }

        JSONArray sectionsJson = templateJson.getJSONArray("sections");

        for (int i = 0; i < sectionsJson.length(); i++) {
            JSONObject sectionJson = sectionsJson.getJSONObject(i);
            String sectionId = sectionJson.getString("id");
            int sectionOrder = sectionJson.getInt("order");
            String sectionTitle = sectionJson.getString("title");
            boolean isRequired = sectionJson.getBoolean("isRequired");
            boolean isExternal = sectionJson.getBoolean("isExternal");

            if (isRequired) {
                Section section = new Section(sectionId, sectionOrder, sectionTitle, "");
                this.templates.computeIfAbsent(collegeId, v -> new ArrayList<>()).add(section);
            }

            if (isExternal) {
                JSONObject externalRef = sectionJson.getJSONObject("externalRef");
                String url = externalRef.getString("url");
                String domSelector = externalRef.getString("selector");

                WebContent webContent = null;
                try {
                    webContent = new WebContent(new URL(url), domSelector, null, "", "");
                } catch (MalformedURLException e) {
                    throw new RuntimeException("Malformed URL in the template file: " + templatePath, e);
                }
                this.scrapedWebContent.add(webContent);
            }

        }
    }

}
