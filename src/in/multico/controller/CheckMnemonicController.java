package in.multico.controller;

import in.multico.Main;
import in.multico.listener.CloseListener;
import in.multico.listener.ShowListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import np.com.ngopal.control.AutoFillTextBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Copyright © 2016 Marat Shmush. All rights reserved.
 * Date: 05.02.16
 * Time: 09:38
 */
public class CheckMnemonicController extends ControllerBased implements Initializable{

    public AutoFillTextBox w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14, w15, w16, w17, w18;
    private List<String> mm;

    @FXML
    private void next(ActionEvent event) {
        try {
            if (mm != null) {
                if (!mm.get(0).equals(w1.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(1).equals(w2.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(2).equals(w3.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(3).equals(w4.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(4).equals(w5.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(5).equals(w6.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(6).equals(w7.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(7).equals(w8.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(8).equals(w9.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(9).equals(w10.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(10).equals(w11.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(11).equals(w12.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(12).equals(w13.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(13).equals(w14.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(14).equals(w15.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(15).equals(w16.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(16).equals(w17.getText().trim())) showErr(w1.getText(), event);
                if (!mm.get(17).equals(w18.getText().trim())) showErr(w1.getText(), event);
            } else {
                mm = new ArrayList<>();
                mm.add(w1.getText());
                mm.add(w2.getText());
                mm.add(w3.getText());
                mm.add(w4.getText());
                mm.add(w5.getText());
                mm.add(w6.getText());
                mm.add(w7.getText());
                mm.add(w8.getText());
                mm.add(w9.getText());
                mm.add(w10.getText());
                mm.add(w11.getText());
                mm.add(w12.getText());
                mm.add(w13.getText());
                mm.add(w14.getText());
                mm.add(w15.getText());
                mm.add(w16.getText());
                mm.add(w17.getText());
                mm.add(w18.getText());
            }
            Main.refreshLayout(event, new SetPasswordController().getLayout(), new ShowListener() {
                @Override
                public void onShow(Object controller) {
                    ((SetPasswordController) controller).setMnemonic(mm, null);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMnemonic(List<String> mm) {
        this.mm = mm;
       // TODO: stub
//        w1.getTextbox().setText(mm.get(0));
//        w2.getTextbox().setText(mm.get(1));
//        w3.getTextbox().setText(mm.get(2));
//        w4.getTextbox().setText(mm.get(3));
//        w5.getTextbox().setText(mm.get(4));
//        w6.getTextbox().setText(mm.get(5));
//        w7.getTextbox().setText(mm.get(6));
//        w8.getTextbox().setText(mm.get(7));
//        w9.getTextbox().setText(mm.get(8));
//        w10.getTextbox().setText(mm.get(9));
//        w11.getTextbox().setText(mm.get(10));
//        w12.getTextbox().setText(mm.get(11));
//        w13.getTextbox().setText(mm.get(12));
//        w14.getTextbox().setText(mm.get(13));
//        w15.getTextbox().setText(mm.get(14));
//        w16.getTextbox().setText(mm.get(15));
//        w17.getTextbox().setText(mm.get(16));
//        w18.getTextbox().setText(mm.get(17));
    }

    private void showErr(String word, final ActionEvent event) throws Exception {
        Main.showMessage(Main.getLocString("err_data"), new CloseListener() {
            @Override
            public void onClose() {
                Main.refreshLayout(event, new ShowMnemonicController().getLayout(), new ShowListener() {
                    @Override
                    public void onShow(Object controller) {
                        ShowMnemonicController c = (ShowMnemonicController) controller;
                        c.setMnemonic(mm);
                        c.setNextCheck();
                    }
                });
            }
        });
        throw new Exception("invalid word: " + word);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!Main.isWindows() && !Main.isUnix()) {
            List<String> mnemonicWorList = Main.getInstance().getMnemonicWorList();
            ObservableList<String> ol = FXCollections.observableList(mnemonicWorList);
            w1.setData(ol);
            w2.setData(ol);
            w3.setData(ol);
            w4.setData(ol);
            w5.setData(ol);
            w6.setData(ol);
            w7.setData(ol);
            w8.setData(ol);
            w9.setData(ol);
            w10.setData(ol);
            w11.setData(ol);
            w12.setData(ol);
            w13.setData(ol);
            w14.setData(ol);
            w15.setData(ol);
            w16.setData(ol);
            w17.setData(ol);
            w18.setData(ol);
        }
    }

    @Override
    public String getLayout() {
        return "check_mnemonic.fxml";
    }

    @Override
    protected void refresh() {

    }
}
