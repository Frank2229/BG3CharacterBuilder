package com.advantageplay.bg3characterbuilder;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MasterButton extends StackPane {
    private final Button button = new Button();
    private final ImageView buttonImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/MasterButton.png").toString()));
    public MasterButton(String buttonName) {
        button.setOpacity(0);
        button.setMinSize(220, 55);
        buttonImageView.setFitHeight(55);
        buttonImageView.setPreserveRatio(true);
        Label label = new Label(buttonName);
        getChildren().addAll(buttonImageView, label, button);
    }

    public Button getButton() {
        return button;
    }

    public ImageView getButtonImageView() {
        return buttonImageView;
    }
}
