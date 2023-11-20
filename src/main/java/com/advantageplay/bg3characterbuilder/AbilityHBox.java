package com.advantageplay.bg3characterbuilder;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class AbilityHBox extends HBox {

    private final AddRemoveButton decreaseButton = new AddRemoveButton("-");
    private final AddRemoveButton increaseButton = new AddRemoveButton("+");
    private final CheckBox twoBonusCheckBox = new CheckBox("+2");
    private final CheckBox oneBonusCheckBox = new CheckBox("+1");
    private final Label modifierLabel = new Label("-1");
    private final Label valueLabel = new Label("8");
    private int adjustedValue = 8;
    private int modifier = -1;
    private int requiredPoints = 1;
    private int temp = 0;
    private int value = 8;

    public AbilityHBox(String abilityName) {
        modifierLabel.getStyleClass().add("modifier-label");
        HBox buttonHBox = new HBox(decreaseButton, increaseButton);
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.setSpacing(7);
        twoBonusCheckBox.getStyleClass().add("modifier-label");
        oneBonusCheckBox.getStyleClass().add("modifier-label");
        HBox bonusHBox = new HBox(twoBonusCheckBox, oneBonusCheckBox);
        bonusHBox.setAlignment(Pos.CENTER);
        bonusHBox.setSpacing(7);
        getChildren().addAll(new Label(abilityName), modifierLabel, valueLabel, buttonHBox, bonusHBox);
        setAlignment(Pos.CENTER);
        setSpacing(20);
    }

    public void calculateNewValue() {
        if (oneBonusCheckBox.isSelected()) adjustedValue = value + 1;
        else if (twoBonusCheckBox.isSelected()) adjustedValue = value + 2;
        else adjustedValue = value;
        valueLabel.setText(Integer.toString(adjustedValue));
        modifier = (adjustedValue - 10) / 2;
        if ((adjustedValue - 10) == -1) modifier--;
        if (modifier >= 0) modifierLabel.setText("+" + Integer.toString(modifier));
        else modifierLabel.setText(Integer.toString(modifier));
    }

    public int decrease(int totalAbilityPoints) {
        temp = totalAbilityPoints;

        if (value > 8) {
            value--;
            calculateNewValue();
            if (value <= 12) requiredPoints = 1;
            else requiredPoints = 2;
            temp = temp + requiredPoints;
        }

        return temp;
    }

    public int getAdjustedValue() { return adjustedValue; }
    public AddRemoveButton getDecreaseButton() {
        return decreaseButton;
    }
    public AddRemoveButton getIncreaseButton() {
        return increaseButton;
    }
    public CheckBox getOneBonusCheckBox() { return oneBonusCheckBox; }
    public CheckBox getTwoBonusCheckBox() { return twoBonusCheckBox; }

    public int increase(int totalAbilityPoints) {
        temp = totalAbilityPoints;

        if (value < 15 && temp >= requiredPoints) {
            value++;
            calculateNewValue();
            temp = temp - requiredPoints;
            if (value <= 12) requiredPoints = 1;
            else requiredPoints = 2;
        }

        return temp;
    }

    public int getModifier() {
        return modifier;
    }

    public void setAdjustedValue(int adjustedValue) {
        this.adjustedValue = adjustedValue;
        calculateNewValue();
    }
}