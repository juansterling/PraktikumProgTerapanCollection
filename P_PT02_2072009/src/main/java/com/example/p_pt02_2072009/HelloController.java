package com.example.p_pt02_2072009;

import com.example.p_pt02_2072009.model.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private TableView<Mahasiswa> tabel;
    @FXML
    private TableColumn<Integer,Mahasiswa> coloumn1;
    @FXML
    private TableColumn<String,Mahasiswa> coloumn2;
    @FXML
    private TableColumn<Float,Mahasiswa> coloumn3;
    @FXML
    private TableColumn<Float,Mahasiswa> coloumn4;
    @FXML
    private TextField nrp;
    @FXML
    private TextField nama;
    @FXML
    private TextField ipa;
    @FXML
    private TextField ips;
    @FXML
    public Button tambah;
    @FXML
    public Button update;
    @FXML
    public Button hapus;

    public ObservableList<Mahasiswa> dataMahasiswa;
    public int index;
    public void initialize() {
        dataMahasiswa = FXCollections.observableArrayList(
                new Mahasiswa(1111, "Juan", 90, 90),
                new Mahasiswa(2222, "Sterling", 90, 90),
                new Mahasiswa(3333, "Martua", 90, 90)

        );
        tabel.setItems(dataMahasiswa);
        coloumn1.setCellValueFactory(new PropertyValueFactory<>("nrp"));
        coloumn2.setCellValueFactory(new PropertyValueFactory<>("nama"));
        coloumn3.setCellValueFactory(new PropertyValueFactory<>("ipa"));
        coloumn4.setCellValueFactory(new PropertyValueFactory<>("ips"));
    }

    ;

    @FXML
    protected void tambah() {
        int nrpBaru = Integer.parseInt(nrp.getText());
        String namaBaru = nama.getText();
        float nilaiipa = Float.parseFloat(ipa.getText());
        float nilaiips = Float.parseFloat(ips.getText());
        dataMahasiswa.add(new Mahasiswa(nrpBaru, namaBaru, nilaiipa, nilaiips));
        nrp.clear();
        nama.clear();
        ipa.clear();
        ips.clear();
    }

    ;
    @FXML
    protected void update() {
        int upNrp = Integer.parseInt(nrp.getText());
        String upNama = nama.getText();
        float upIpa = Float.parseFloat(ipa.getText());
        float upIps = Float.parseFloat(ips.getText());
        dataMahasiswa.set(index, new Mahasiswa(upNrp, upNama, upIpa, upIps));
        nrp.clear();
        nama.clear();
        ipa.clear();
        ips.clear();
    }
    @FXML
    protected void hapus() {
        int nrpDel = Integer.parseInt(nrp.getText());
        for (Mahasiswa st : dataMahasiswa) {
            if (nrpDel == st.getNrp()) {
                dataMahasiswa.remove(st);
                break;
            }
        }
        nrp.clear();
        nama.clear();
        ipa.clear();
        ips.clear();

    };

    @FXML
    public void datadipilih(MouseEvent mouseEvent) {
        if (!tabel.getSelectionModel().getSelectedCells().isEmpty()) {
            tambah.setDisable(true);
            update.setDisable(false);
            hapus.setDisable(false);
            index = tabel.getSelectionModel().getSelectedIndex();
        }
        nrp.setText(String.valueOf(tabel.getSelectionModel().getSelectedItem().getNrp()));
        nama.setText(tabel.getSelectionModel().getSelectedItem().getNama());
        ipa.setText(String.valueOf(tabel.getSelectionModel().getSelectedItem().getIpa()));
        ips.setText(String.valueOf(tabel.getSelectionModel().getSelectedItem().getIps()));
    }
}
