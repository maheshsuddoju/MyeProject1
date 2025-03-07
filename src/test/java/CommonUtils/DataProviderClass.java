package CommonUtils;


import org.testng.annotations.DataProvider;

import java.util.List;


public class    DataProviderClass {

    @DataProvider(name = "csvDataProvider")
    public Object[][] getDataFromCSV() {
        String filePath = "src/main/resources/data.csv";
        List<String[]> data = CSVReader.readCSV(filePath);
        Object[][] dataArray = new Object[data.size()][2];

        for (int i = 0; i < data.size(); i++) {
            dataArray[i] = data.get(i);

        }
        return dataArray;
    }
}
