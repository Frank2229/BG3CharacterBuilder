package com.advantageplay.bg3characterbuilder;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class AddRemoveButton extends StackPane {
    private final Button button = new Button();
    public AddRemoveButton(String buttonName) {
        button.setMinSize(25, 25);
        button.setOpacity(0);
        ImageView buttonImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/AddRemoveButton.png").toString()));
        buttonImageView.setFitWidth(25);
        buttonImageView.setFitHeight(25);
        Label label = new Label(buttonName);
        label.getStyleClass().add("header-label");
        getChildren().addAll(buttonImageView, label, button);
        buttonImageView.setTranslateY(2);
    }

    public Button getButton() {
        return button;
    }
}
