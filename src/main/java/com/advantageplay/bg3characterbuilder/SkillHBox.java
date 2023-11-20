package com.advantageplay.bg3characterbuilder;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class SkillHBox extends HBox {
    private AbilityHBox ability;
    private final CheckBox skillCheckBox = new CheckBox();
    private int backgroundBonus;
    private int raceBonus = 0;
    private int selectBonus = 0;
    private Label modifierLabel;
    public SkillHBox(String skillName, int backgroundBonus, int modifier, AbilityHBox ability) {
        this.ability = ability;
        this.backgroundBonus = backgroundBonus;
        modifierLabel = new Label(Integer.toString(backgroundBonus + modifier));
        modifierLabel.getStyleClass().add("modifier-label");
        Label skillLabel = new Label(skillName);
        skillLabel.getStyleClass().add("skills-label");
        if (backgroundBonus > 0) skillCheckBox.setVisible(false);
        getChildren().addAll(skillLabel, modifierLabel, skillCheckBox);
        setAlignment(Pos.CENTER);
        setSpacing(20);
    }

    public AbilityHBox getAbility() { return ability; }

    public int getBackgroundBonus() { return backgroundBonus; }

    public Label getModifierLabel() {
        return modifierLabel;
    }

    public int getRaceBonus() {
        return raceBonus;
    }

    public int getSelectBonus() { return selectBonus; }

    public CheckBox getSkillCheckBox() {
        return skillCheckBox;
    }

    public void setBackgroundBonus(int backgroundBonus) { this.backgroundBonus = backgroundBonus; }

    public void setRaceBonus(int raceBonus) {
        this.raceBonus = raceBonus;
    }

    public void setSelectBonus(int selectBonus) { this.selectBonus = selectBonus; }
}
