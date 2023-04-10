package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;


    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        if (stringList == null) {
            return;
        }

        stringArrayList = new LinkedList<>(stringList);

        for (String s : stringArrayList) {
            System.out.println(s.hashCode());
        }

    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        if (stringList == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : stringArrayList) {
            sb.append(s)
                    .append(" ");
        }

        processorName = sb.toString();

        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        if (!file.exists()) {
            return;
        }

        informationScanner = new Scanner(file);

        StringBuilder sb = new StringBuilder();

        while (informationScanner.hasNext()) {
            sb.append(informationScanner.nextLine());
        }

        informationScanner.close();
        processorVersion = sb.toString();

    }
}
