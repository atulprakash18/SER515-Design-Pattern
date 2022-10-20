package edu.asu.ser515.team33.syllabusgenerator;

import edu.asu.ser515.team33.syllabusgenerator.adapter.Canvas;
import edu.asu.ser515.team33.syllabusgenerator.adapter.CanvasImpl;
import edu.asu.ser515.team33.syllabusgenerator.adapter.SyllabusGeneratorAdapter;
import edu.asu.ser515.team33.syllabusgenerator.controller.SyllabusGeneratorController;
import edu.asu.ser515.team33.syllabusgenerator.controller.SyllabusGeneratorControllerImpl;
import edu.asu.ser515.team33.syllabusgenerator.exporter.SyllabusExporterServiceImpl;
import edu.asu.ser515.team33.syllabusgenerator.generator.SyllabusGeneratorService;
import edu.asu.ser515.team33.syllabusgenerator.generator.SyllabusGeneratorServiceImpl;
import edu.asu.ser515.team33.syllabusgenerator.importer.SyllabusImporterServiceImpl;
import edu.asu.ser515.team33.syllabusgenerator.scraper.BasicWebContentWatcher;
import edu.asu.ser515.team33.syllabusgenerator.scraper.WebContent;
import edu.asu.ser515.team33.syllabusgenerator.util.ConfigUtil;

import java.util.Set;
import java.util.Timer;

public class MainApplication {
    public static void main(String[] args) {
        ConfigUtil configUtil = ConfigUtil.getInstance();

        Set<WebContent> webContentWatchers = configUtil.getScrapedWebContent();
        System.out.println("Scheduling web content watchers to monitor every 30s");
        for (WebContent webContent : webContentWatchers) {
            new Timer().scheduleAtFixedRate(new BasicWebContentWatcher(webContent), 0, 30000);
        }

        Canvas canvas = new SyllabusGeneratorAdapter(new SyllabusGeneratorControllerImpl(new SyllabusImporterServiceImpl(), new SyllabusGeneratorServiceImpl(), new SyllabusExporterServiceImpl()));
        canvas.generateSyllabus("SER515");
    }
}
