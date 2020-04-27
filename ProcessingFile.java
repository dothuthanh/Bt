import java.io.*;
import java.util.List;

public class ProcessingFile {
    public void write(String FilePath, List<Phone> phoneList){
        try {
            FileWriter file = new FileWriter(FilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            for (int i = 0 ; i < phoneList.size(); i++){
                bufferedWriter.write("ID:" + phoneList.get(i).getNumber() + "|\n" + "Loai giay:" + phoneList.get(i).getName() + "|\n" + "Gioi tinh" + phoneList.get(i).getSex() + "|\n" + "Dia chi" + phoneList.get(i).getAddress() + "\n------------------------------------\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void read(List<Phone> phoneList) throws Exception{
        try {
            File file = new File("file.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


