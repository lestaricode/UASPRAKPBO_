package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import java.io.*;

public class Controller {
    @FXML
    TextField tfNama;
    @FXML
    TextField tfAlamat;
    @FXML
    TextField tfPosisi;
    @FXML
    TextField tfUmur;
    @FXML
    TextField tfJenisK;

    @FXML
    Button btnsubmit;
    @FXML
    TableView<KaryawanModel> tvDataKaryawan;
    @FXML
    Button btnsave;
    @FXML
    Button btnload;

    @FXML
    public void onButtonClicked(ActionEvent e){
        if (e.getTarget().equals(btnsubmit)){
            ObservableList<KaryawanModel> data = tvDataKaryawan.getItems();
            data.add(new KaryawanModel(
                    tfNama.getText(),
                    tfAlamat.getText(),
                    tfPosisi.getText(),
                    tfUmur.getText(),
                    tfJenisK.getText()
            ));

            tfNama.setText("");
            tfAlamat.setText("");
            tfPosisi.setText("");
            tfUmur.setText("");
            tfJenisK.setText("");

        }else if (e.getTarget().equals(btnsave)){
            try {
                ObservableList<KaryawanModel> data = tvDataKaryawan.getItems();
                BufferedWriter writer = new BufferedWriter(new FileWriter("data-karyawan.dat"));
                for (KaryawanModel aData : data) {
                    writer.write(String.valueOf(aData.getNama()) +
                            "," + String.valueOf(aData.getAlamat()) +
                            "," + String.valueOf(aData.getPosisi()) +
                            "," + String.valueOf(aData.getUmur()) +
                            "," + String.valueOf(aData.getJenisk()));
                    writer.newLine();


                }
                writer.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sukses");
                alert.setContentText("Sukses Menyimpan Data ke File");
                alert.showAndWait();
            }catch (IOException ex){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Error IO Exception : " + ex.getMessage());
                alert.showAndWait();
            }
        } else if (e.getTarget().equals(btnload)){
            try{
                ObservableList<KaryawanModel> data = tvDataKaryawan.getItems();
                data.clear();
                BufferedReader reader = new BufferedReader(new FileReader("data-karyawan.dat"));
                String line;
                while ((line = reader.readLine())!= null) {
                    String[] temp = line.split(",");
                    KaryawanModel karyawanModel = new KaryawanModel(temp[2],temp[3],temp[4],temp[5],temp[6]);
                    data.add(karyawanModel);
                }
                reader.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sukses");
                alert.setContentText("Sukses Menyimpan Data ke File");
                alert.showAndWait();
            }catch (IOException ex){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Error IO Exception : " + ex.getMessage());
                alert.showAndWait();

            }
        }

    }
}



