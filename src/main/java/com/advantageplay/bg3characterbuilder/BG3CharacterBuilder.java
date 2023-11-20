package com.advantageplay.bg3characterbuilder;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.print.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

public class BG3CharacterBuilder extends Application {
    private final AbilityHBox strengthHBox = new AbilityHBox("Strength");
    private final AbilityHBox dexterityHBox = new AbilityHBox("Dexterity");
    private final AbilityHBox constitutionHBox = new AbilityHBox("Constitution");
    private final AbilityHBox intelligenceHBox = new AbilityHBox("Intelligence");
    private final AbilityHBox wisdomHBox = new AbilityHBox("Wisdom");
    private final AbilityHBox charismaHBox = new AbilityHBox("Charisma");
    private boolean isOneBonusSelected = false;
    private boolean isTwoBonusSelected = false;
    private ChoiceBox<String> deityChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Selune", "Bahamut", "Tempus", "Tyr", "Helm", "Ilmater", "Mystra", "Oghma", "Kelemvor", "Moradin", "Corellon Larethian", "Garl Glittergold", "Yondalla", "Lolth", "Gruumsh", "Tiamat", "Vlaakith", "Eilistraee", "Lathander", "Talos", "Tymora", "Mielikki"));
    private ChoiceBox<String> elfSubraceChoiceBox;
    private ChoiceBox<String> tieflingSubraceChoiceBox;
    private ChoiceBox<String> drowSubraceChoiceBox;
    private ChoiceBox<String> dwarfSubraceChoiceBox;
    private ChoiceBox<String> halfElfSubraceChoiceBox;
    private ChoiceBox<String> halflingSubraceChoiceBox;
    private ChoiceBox<String> gnomeSubraceChoiceBox;
    private ChoiceBox<String> dragonbornSubraceChoiceBox;
    private ChoiceBox<String> barbarianSubclassChoiceBox;
    private ChoiceBox<String> bardSubclassChoiceBox;
    private ChoiceBox<String> clericSubclassChoiceBox;
    private ChoiceBox<String> druidSubclassChoiceBox;
    private ChoiceBox<String> fighterSubclassChoiceBox;
    private ChoiceBox<String> monkSubclassChoiceBox;
    private ChoiceBox<String> paladinSubclassChoiceBox;
    private ChoiceBox<String> rangerSubclassChoiceBox;
    private ChoiceBox<String> rogueSubclassChoiceBox;
    private ChoiceBox<String> sorcererSubclassChoiceBox;
    private ChoiceBox<String> warlockSubclassChoiceBox;
    private ChoiceBox<String> wizardSubclassChoiceBox;
    private final FlowPane classCantripsFlowPane = new FlowPane();
    private FlowPane spellsFlowPane = new FlowPane();
    private FlowPane raceCantripsFlowPane;
    private HBox deityHBox;
    private HBox subclassHBox;
    private HBox subraceHBox;
    private int remainingClassCantrips = 0;
    private int remainingRaceCantrips = 1;
    private int remainingSkillPoints = 2;
    private int remainingSpellPoints = 0;
    private int tempInt = 0;
    private int totalAbilityPoints = 27;
    private int totalClassCantrips = 0;
    private int totalRaceCantrips = 1;
    private int totalSkillPoints = 2;
    private int totalSpellPoints = 0;
    private Label classCantripPointsLabel;
    private Label raceCantripPointsLabel;
    private Label skillPointsLabel = new Label("(" + remainingSkillPoints + "/" + totalSkillPoints + ")");
    private Label spellsPointsLabel = new Label("(" + remainingSpellPoints + "/" + totalSpellPoints + ")");
    private Label characterSheetNameValueLabel = new Label("Tav");
    private Label characterSheetRaceValueLabel = new Label("High Elf");
    private Label characterSheetClassValueLabel = new Label("Wildheart Barbarian");
    private Label characterSheetBackgroundValueLabel = new Label("Acolyte");
    private Label characterSheetAlignmentValueLabel = new Label("Lawful Good");
    private Label characterSheetStrengthValueLabel = new Label("8");
    private Label characterSheetDexterityValueLabel = new Label("8");
    private Label characterSheetConstitutionValueLabel = new Label("8");
    private Label characterSheetIntelligenceValueLabel = new Label("8");
    private Label characterSheetWisdomValueLabel = new Label("8");
    private Label characterSheetCharismaValueLabel = new Label("8");
    private Label characterSheetStrengthModifierVBox = new Label("-1");
    private Label characterSheetDexterityModifierVBox = new Label("-1");
    private Label characterSheetConsitutionModifierVBox = new Label("-1");
    private Label characterSheetIntelligenceModifierVBox = new Label("-1");
    private Label characterSheetWisdomModifierVBox = new Label("-1");
    private Label characterSheetCharismaModifierVBox = new Label("-1");
    private Label characterSheetAcrobaticsValueLabel = new Label("-1");
    private Label characterSheetAnimalHandlingValueLabel = new Label("-1");
    private Label characterSheetArcanaValueLabel = new Label("-1");
    private Label characterSheetAthleticsValueLabel = new Label("-1");
    private Label characterSheetDeceptionValueLabel = new Label("-1");
    private Label characterSheetHistoryValueLabel = new Label("-1");
    private Label characterSheetInsightValueLabel = new Label("-1");
    private Label characterSheetIntimidationValueLabel = new Label("-1");
    private Label characterSheetInvestigationValueLabel = new Label("-1");
    private Label characterSheetMedicineValueLabel = new Label("-1");
    private Label characterSheetNatureValueLabel = new Label("-1");
    private Label characterSheetPerceptionValueLabel = new Label("-1");
    private Label characterSheetPerformanceValueLabel = new Label("-1");
    private Label characterSheetPersuasionValueLabel = new Label("-1");
    private Label characterSheetReligionValueLabel = new Label("-1");
    private Label characterSheetSleightOfHandValueLabel = new Label("-1");
    private Label characterSheetStealthValueLabel = new Label("-1");
    private Label characterSheetSurvivalValueLabel = new Label("-1");
    private Label characterSheetHPValueLabel = new Label("11");
    private Label characterSheetACValueLabel = new Label("9");
    private Label characterSheetSpeedValueLabel = new Label("9.0m / 30ft");
    private Label characterSheetInitiativeValueLabel = new Label("-1");
    private Label characterSheetArmourProficienciesValuesLabel = new Label("x3");
    private Label characterSheetSimpleWeaponsProficienciesValuesLabel = new Label("x12");
    private Label characterSheetMartialWeaponsProficienciesValuesLabel = new Label("x19");
    private Label characterSheetCarryValueLabel = new Label("120kg / 240lbs");
    private LinkedList<Label> backstoryLabelList = new LinkedList<Label>();
    private LinkedList<Label> characterSheetBackstoryLabelList = new LinkedList<Label>();
    private LinkedList<String> backstoryParagraph = new LinkedList<String>();
    private LinkedList<String> characterSheetBackstoryParagraph = new LinkedList<String>();
    private final Random random = new Random();
    private final SkillHBox athleticsHBox = new SkillHBox("Athletics", 0, -1, strengthHBox);
    private final SkillHBox acrobaticsHBox = new SkillHBox("Acrobatics", 0, -1, dexterityHBox);
    private final SkillHBox sleightOfHandHBox = new SkillHBox("Sleight of Hand", 0, -1, dexterityHBox);
    private final SkillHBox stealthHBox = new SkillHBox("Stealth", 0, -1, dexterityHBox);
    private final SkillHBox arcanaHBox = new SkillHBox("Arcana", 0, -1, intelligenceHBox);
    private final SkillHBox historyHBox = new SkillHBox("History", 0, -1, intelligenceHBox);
    private final SkillHBox investigationHBox = new SkillHBox("Investigation", 0, -1, intelligenceHBox);
    private final SkillHBox natureHBox = new SkillHBox("Nature", 0, -1, intelligenceHBox);
    private final SkillHBox religionHBox = new SkillHBox("Religion", 2, -1, intelligenceHBox);
    private final SkillHBox animalHandlingHBox = new SkillHBox("Animal Handling", 0, -1, wisdomHBox);
    private final SkillHBox insightHBox = new SkillHBox("Insight", 2, -1, wisdomHBox);
    private final SkillHBox medicineHBox = new SkillHBox("Medicine", 0, -1, wisdomHBox);
    private final SkillHBox perceptionHBox = new SkillHBox("Perception", 0, -1, wisdomHBox);
    private final SkillHBox survivalHBox = new SkillHBox("Survival", 0, -1, wisdomHBox);
    private final SkillHBox deceptionHBox = new SkillHBox("Deception", 0, -1, charismaHBox);
    private final SkillHBox intimidationHBox = new SkillHBox("Intimidation", 0, -1, charismaHBox);
    private final SkillHBox performanceHBox = new SkillHBox("Performance", 0, -1, charismaHBox);
    private final SkillHBox persuasionHBox = new SkillHBox("Persuasion", 0, -1, charismaHBox);
    private SpellButton acidSplashRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/AcidSplashIcon.png", "Acid Splash");
    private SpellButton bladeWardRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/BladeWardIcon.png", "Blade Ward");
    private SpellButton boneChillRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/BoneChillIcon.png", "Bone Chill");
    private SpellButton dancingLightsRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/DancingLightsIcon.png", "Dancing Lights");
    private SpellButton fireBoltRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/FireBoltIcon.png", "Fire Bolt");
    private SpellButton friendsRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/FriendsIcon.png", "Friends");
    private SpellButton lightRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/LightIcon.png", "Light");
    private SpellButton mageHandRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/MageHandIcon.png", "Mage Hand");
    private SpellButton minorIllusionRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/MinorIllusionIcon.png", "Minor Illusion");
    private SpellButton poisonSprayRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/PoisonSprayIcon.png", "Poison Spray");
    private SpellButton rayOfFrostRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/RayOfFrostIcon.png", "Ray of Frost");
    private SpellButton shockingGraspRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/ShockingGraspIcon.png", "Shocking Grasp");
    private SpellButton trueStrikeRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/TrueStrikeIcon.png", "True Strike");
    private SpellButton produceFlameRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/ProduceFlameIcon.png", "Produce Flame");
    private SpellButton thaumaturgyRaceButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/ThaumaturgyIcon.png", "Thaumaturgy");
    private SpellButton githyankiMageHandButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/MageHandIcon.png", "Githyanki Psionics:\nMage Hand");
    private SpellButton acidSplashClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/AcidSplashIcon.png", "Acid Splash");
    private SpellButton bladeWardClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/BladeWardIcon.png", "Blade Ward");
    private SpellButton boneChillClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/BoneChillIcon.png", "Bone Chill");
    private SpellButton dancingLightsClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/DancingLightsIcon.png", "Dancing Lights");
    private SpellButton fireBoltClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/FireBoltIcon.png", "Fire Bolt");
    private SpellButton friendsClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/FriendsIcon.png", "Friends");
    private SpellButton lightClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/LightIcon.png", "Light");
    private SpellButton mageHandClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/MageHandIcon.png", "Mage Hand");
    private SpellButton minorIllusionClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/MinorIllusionIcon.png", "Minor Illusion");
    private SpellButton poisonSprayClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/PoisonSprayIcon.png", "Poison Spray");
    private SpellButton rayOfFrostClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/RayOfFrostIcon.png", "Ray of Frost");
    private SpellButton shockingGraspClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/ShockingGraspIcon.png", "Shocking Grasp");
    private SpellButton trueStrikeClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/TrueStrikeIcon.png", "True Strike");
    private SpellButton viciousMockeryClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/ViciousMockeryIcon.png", "Vicious Mockery");
    private SpellButton thaumaturgyClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/ThaumaturgyIcon.png", "Thaumaturgy");
    private SpellButton sacredFlameClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/SacredFlameIcon.png", "Sacred Flame");
    private SpellButton guidanceClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/GuidanceIcon.png", "Guidance");
    private SpellButton resistanceClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/ResistanceIcon.png", "Resistance");
    private SpellButton produceFlameClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/ProduceFlameIcon.png", "Produce Flame");
    private SpellButton shillelaghClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/ShillelaghIcon.png", "Shillelagh");
    private SpellButton thornWhipClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/ThornWhipIcon.png", "Thorn Whip");
    private SpellButton eldritchBlastClassButton = new SpellButton("/com/advantageplay/bg3characterbuilder/cantrips/EldritchBlastIcon.png", "Eldritch Blast");
    private SpellButton animalFriendshipSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/AnimalFriendshipIcon.png", "Animal Friendship");
    private SpellButton armourOfAgathysSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/ArmourOfAgathysIcon.png", "Armour of Agathys");
    private SpellButton armsOfHadarSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/ArmsOfHadarIcon.png", "Arms of Hadar");
    private SpellButton baneSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/BaneIcon.png", "Bane");
    private SpellButton burningHandsSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/BurningHandsIcon.png", "Burning Hands");
    private SpellButton charmPersonSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/CharmPersonIcon.png", "Charm Person");
    private SpellButton chromaticOrbSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/ChromaticOrbIcon.png", "Chromatic Orb");
    private SpellButton colourSpraySpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/ColourSprayIcon.png", "Colour Spray");
    private SpellButton commandSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/CommandIcon.png", "Command");
    private SpellButton cureWoundsSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/CureWoundsIcon.png", "Cure Wounds");
    private SpellButton disguiseSelfSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/DisguiseSelfIcon.png", "Disguise Self");
    private SpellButton dissonantWhispersSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/DissonantWhispersIcon.png", "Dissonant Whispers");
    private SpellButton divineFavourSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/DivineFavourIcon.png", "Divine Favour");
    private SpellButton enhanceLeapSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/EnhanceLeapIcon.png", "Enhance Leap");
    private SpellButton expeditiousRetreatSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/ExpeditiousRetreatIcon.png", "Expeditious\nRetreat");
    private SpellButton faerieFireSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/FaerieFireIcon.png", "Faerie Fire");
    private SpellButton falseLifeSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/FalseLifeIcon.png", "False Life");
    private SpellButton featherFallSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/FeatherFallIcon.png", "Feather Fall");
    private SpellButton findFamiliarSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/FindFamiliarIcon.png", "Find Familiar");
    private SpellButton fogCloudSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/FogCloudIcon.png", "Fog Cloud");
    private SpellButton greaseSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/GreaseIcon.png", "Grease");
    private SpellButton guidingBoltSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/GuidingBoltIcon.png", "Guiding Bolt");
    private SpellButton healingWordSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/HealingWordIcon.png", "Healing Word");
    private SpellButton hellishRebukeSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/HellishRebukeIcon.png", "Hellish Rebuke");
    private SpellButton heroismSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/HeroismIcon.png", "Heroism");
    private SpellButton iceKnifeSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/IceKnifeIcon.png", "Ice Knife");
    private SpellButton inflictWoundsSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/InflictWoundsIcon.png", "Inflict Wounds");
    private SpellButton longstriderSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/LongstriderIcon.png", "Longstrider");
    private SpellButton mageArmourSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/MageArmourIcon.png", "Mage Armour");
    private SpellButton magicMissileSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/MagicMissileIcon.png", "Magic Missile");
    private SpellButton protectionFromEvilAndGoodSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/ProtectionFromEvilAndGoodIcon.png", "Protection From\nEvil and Good");
    private SpellButton rayOfSicknessSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/RayOfSicknessIcon.png", "Ray of Sickness");
    private SpellButton shieldSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/ShieldIcon.png", "Shield");
    private SpellButton shieldOfFaithSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/ShieldOfFaithIcon.png", "Shield of Faith");
    private SpellButton sleepSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/SleepIcon.png", "Sleep");
    private SpellButton speakWithAnimalsSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/SpeakWithAnimalsIcon.png", "Speak With Animals");
    private SpellButton tashasHideousLaughterSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/TashasHideousLaughterIcon.png", "Tasha's Hideous\nLaughter");
    private SpellButton thunderwaveSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/ThunderwaveIcon.png", "Thunderwave");
    private SpellButton witchboltSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/WitchboltIcon.png", "Witchbolt");
    private SpellButton sanctuarySpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/SantuaryIcon.png", "Sanctuary");
    private SpellButton blessSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/BlessIcon.png", "Bless");
    private SpellButton createOrDestroyWaterSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/CreateOrDestroyWaterIcon.png", "Create or\nDestroy Water");
    private SpellButton goodberrySpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/GoodberryIcon.png", "Goodberry");
    private SpellButton hexSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/HexIcon.png", "Hex");
    private SpellButton entangleSpellButton = new SpellButton("/com/advantageplay/bg3characterbuilder/spells/EntangleIcon.png", "Entangle");
    private String background = "Acolyte";
    private String backstoryString = "";
    private String characterSheetBackstoryString = "";
    private String deity = "";
    private String gender = "Female";
    private String goodEvilString = "Good";
    private String lawfulChaoticString = "Lawful";
    private String playerClass = "Barbarian";
    private String playerName = "Tav";
    private String race = "Elf";
    private String subclass = "Wildheart";
    private String subrace = "High Elf";
    private String tempString = "";
    private final TextField nameTextField = new TextField("Tav");
    private VBox characterCustomizerAttributesVBox;
    private VBox characterSheetBackstoryParagraphVBox = new VBox();

    @Override
    public void start(Stage stage) throws IOException {
        ImageView backgroundImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/CharacterCreatorBackground.png").toString()));
        backgroundImageView.setFitWidth(1500);
        backgroundImageView.setPreserveRatio(true);
        ImageView borderImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/MenuBorder.png").toString()));
        borderImageView.setFitWidth(1000);
        borderImageView.setPreserveRatio(true);

        nameTextField.setMaxWidth(250);
        nameTextField.setOnAction(event -> setPlayerName(nameTextField.getText()));
        MenuButton randomNameButton = new MenuButton("Random");
        randomNameButton.getButtonImageView().setPreserveRatio(false);
        randomNameButton.getButtonImageView().setFitWidth(100);
        randomNameButton.getButton().setOnAction(event -> generateRandomName());
        HBox nameHBox = new HBox(new Label("Name: "), nameTextField, randomNameButton);
        nameHBox.setSpacing(20);

        ToggleGroup genderToggleGroup = new ToggleGroup();
        RadioButton genderFemaleRadioButton = new RadioButton("Female");
        genderFemaleRadioButton.setToggleGroup(genderToggleGroup);
        genderFemaleRadioButton.setSelected(true);
        genderFemaleRadioButton.setOnAction(event -> setGender("Female"));
        RadioButton genderMaleRadioButton = new RadioButton("Male");
        genderMaleRadioButton.setToggleGroup(genderToggleGroup);
        genderMaleRadioButton.setOnAction(event -> setGender("Male"));
        RadioButton genderNonBinaryRadioButton = new RadioButton("Non-Binary");
        genderNonBinaryRadioButton.setToggleGroup(genderToggleGroup);
        genderNonBinaryRadioButton.setOnAction(event -> setGender("Non-Binary"));
        HBox genderToggleHBox = new HBox(genderFemaleRadioButton, genderMaleRadioButton, genderNonBinaryRadioButton);
        genderToggleHBox.setSpacing(10);
        HBox genderHBox = new HBox(new Label("Gender: "), genderToggleHBox);
        genderHBox.setSpacing(20);

        ChoiceBox<String> raceChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Elf", "Tiefling", "Drow", "Human", "Githyanki", "Dwarf", "Half-Elf", "Halfling", "Gnome", "Dragonborn", "Half-Orc"));
        raceChoiceBox.setValue("Elf");
        raceChoiceBox.setOnAction(event -> setRace(raceChoiceBox.getValue()));
        HBox raceHBox = new HBox(new Label("Race: "), raceChoiceBox);
        raceHBox.setSpacing(20);

        elfSubraceChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("High Elf", "Wood Elf"));
        elfSubraceChoiceBox.setValue("High Elf");
        elfSubraceChoiceBox.setOnAction(event -> setSubrace(elfSubraceChoiceBox.getValue()));
        tieflingSubraceChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Asmodeus Tiefling", "Mephistopheles Tiefling", "Zariel Tiefling"));
        tieflingSubraceChoiceBox.setValue("Asmodeus Tiefling");
        tieflingSubraceChoiceBox.setOnAction(event -> setSubrace(tieflingSubraceChoiceBox.getValue()));
        drowSubraceChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Lolth-Sworn Drow", "Seldarine Drow"));
        drowSubraceChoiceBox.setValue("Lolth-Sworn Drow");
        drowSubraceChoiceBox.setOnAction(event -> setSubrace(drowSubraceChoiceBox.getValue()));
        dwarfSubraceChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Hill Dwarf", "Mountain Dwarf", "Duergar"));
        dwarfSubraceChoiceBox.setValue("Hill Dwarf");
        dwarfSubraceChoiceBox.setOnAction(event -> setSubrace(dwarfSubraceChoiceBox.getValue()));
        halfElfSubraceChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("High Half-Elf", "Wood Half-Elf", "Drow Half-Elf"));
        halfElfSubraceChoiceBox.setValue("High Half-Elf");
        halfElfSubraceChoiceBox.setOnAction(event -> setSubrace(halfElfSubraceChoiceBox.getValue()));
        halflingSubraceChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Lightfoot Halfling", "Strongheart Halfling"));
        halflingSubraceChoiceBox.setValue("Lightfoot Halfling");
        halflingSubraceChoiceBox.setOnAction(event -> setSubrace(halflingSubraceChoiceBox.getValue()));
        gnomeSubraceChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Rock Gnome", "Forest Gnome", "Deep Gnome"));
        gnomeSubraceChoiceBox.setValue("Rock Gnome");
        gnomeSubraceChoiceBox.setOnAction(event -> setSubrace(gnomeSubraceChoiceBox.getValue()));
        dragonbornSubraceChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Black Dragonborn", "Blue Dragonborn", "Copper Dragonborn", "Gold Dragonborn", "Green Dragonborn", "Red Dragonborn", "Brass Dragonborn", "Bronze Dragonborn", "Silver Dragonborn", "White Dragonborn"));
        dragonbornSubraceChoiceBox.setValue("Black Dragonborn");
        dragonbornSubraceChoiceBox.setOnAction(event -> setSubrace(dragonbornSubraceChoiceBox.getValue()));
        subraceHBox = new HBox(new Label("Subrace: "), elfSubraceChoiceBox);
        subraceHBox.setSpacing(20);

        ChoiceBox<String> playerClassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"));
        playerClassChoiceBox.setValue("Barbarian");
        playerClassChoiceBox.setOnAction(event -> setPlayerClass(playerClassChoiceBox.getValue()));
        HBox playerClassHBox = new HBox(new Label("Class: "), playerClassChoiceBox);
        playerClassHBox.setSpacing(20);

        barbarianSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Wildheart", "Berserker", "Wild Magic"));
        barbarianSubclassChoiceBox.setValue("Wildheart");
        barbarianSubclassChoiceBox.setOnAction(event -> setSubclass(barbarianSubclassChoiceBox.getValue()));
        bardSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Lore", "Valour", "Swords"));
        bardSubclassChoiceBox.setValue("Lore");
        bardSubclassChoiceBox.setOnAction(event -> setSubclass(bardSubclassChoiceBox.getValue()));
        clericSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Life Domain", "Light Domain", "Trickery Domain", "Knowledge Domain", "Nature Domain", "Tempest Domain", "War Domain"));
        clericSubclassChoiceBox.setValue("Life");
        clericSubclassChoiceBox.setOnAction(event -> setSubclass(clericSubclassChoiceBox.getValue()));
        druidSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Circle of the Land", "Circle of the Moon", "Circle of Spores"));
        druidSubclassChoiceBox.setValue("Circle of the Land");
        druidSubclassChoiceBox.setOnAction(event -> setSubclass(druidSubclassChoiceBox.getValue()));
        fighterSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Battle Master", "Eldritch Knight", "Champion"));
        fighterSubclassChoiceBox.setValue("Battle Master");
        fighterSubclassChoiceBox.setOnAction(event -> setSubclass(fighterSubclassChoiceBox.getValue()));
        monkSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Way of the Four Elements", "Way of the Open Hand", "Way of the Shadow"));
        monkSubclassChoiceBox.setValue("Way of the Four Elements");
        monkSubclassChoiceBox.setOnAction(event -> setSubclass(monkSubclassChoiceBox.getValue()));
        paladinSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Oath of the Ancients", "Oath of Devotion", "Oath of Vengeance"));
        paladinSubclassChoiceBox.setValue("Oath of the Ancients");
        paladinSubclassChoiceBox.setOnAction(event -> setSubclass(paladinSubclassChoiceBox.getValue()));
        rangerSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Beast Master", "Gloom Stalker", "Hunter"));
        rangerSubclassChoiceBox.setValue("Beast Master");
        rangerSubclassChoiceBox.setOnAction(event -> setSubclass(rangerSubclassChoiceBox.getValue()));
        rogueSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Thief", "Arcane Trickster", "Assassin"));
        rogueSubclassChoiceBox.setValue("Thief");
        rogueSubclassChoiceBox.setOnAction(event -> setSubclass(rogueSubclassChoiceBox.getValue()));
        sorcererSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Wild Magic", "Draconic Bloodline", "Storm Sorcery"));
        sorcererSubclassChoiceBox.setValue("Wild Magic");
        sorcererSubclassChoiceBox.setOnAction(event -> setSubclass(sorcererSubclassChoiceBox.getValue()));
        warlockSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("The Fiend", "The Great Old One", "The Archfey"));
        warlockSubclassChoiceBox.setValue("The Fiend");
        warlockSubclassChoiceBox.setOnAction(event -> setSubclass(warlockSubclassChoiceBox.getValue()));
        wizardSubclassChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Abjuration", "Evocation", "Necromancy", "Conjuration", "Enchantment", "Divination", "Illusion", "Transmutation"));
        wizardSubclassChoiceBox.setValue("Abjuration");
        wizardSubclassChoiceBox.setOnAction(event -> setSubclass(wizardSubclassChoiceBox.getValue()));
        subclassHBox = new HBox(new Label("Subclass: "), barbarianSubclassChoiceBox);
        subclassHBox.setSpacing(20);

        deityChoiceBox.setOnAction((event -> deity = deityChoiceBox.getValue()));
        deityHBox = new HBox(new Label("Deity: "), deityChoiceBox);
        deityHBox.setSpacing(20);

        MenuButton cantripsButton = new MenuButton("Select");
        HBox cantripsHBox = new HBox(new Label("Cantrips: "), cantripsButton);
        cantripsHBox.setSpacing(20);

        MenuButton spellsButton = new MenuButton("Select");
        HBox spellsHBox = new HBox(new Label("Spells: "), spellsButton);
        spellsHBox.setSpacing(20);

        ChoiceBox<String> backgroundChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Acolyte", "Charlatan", "Criminal", "Entertainer", "Folk Hero", "Guild Artisan", "Noble", "Outlander", "Sage", "Soldier", "Urchin"));
        backgroundChoiceBox.setValue("Acolyte");
        backgroundChoiceBox.setOnAction(event -> setBackground(backgroundChoiceBox.getValue()));
        HBox backgroundHBox = new HBox(new Label("Background: "), backgroundChoiceBox);
        backgroundHBox.setSpacing(20);
        ChoiceBox<String> lawfulChaoticChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Lawful", "Neutral", "Chaotic"));
        lawfulChaoticChoiceBox.setValue("Lawful");
        lawfulChaoticChoiceBox.setOnAction(event -> lawfulChaoticString = lawfulChaoticChoiceBox.getValue());
        ChoiceBox<String> goodEvilChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList("Good", "Neutral", "Evil"));
        goodEvilChoiceBox.setValue("Good");
        goodEvilChoiceBox.setOnAction(event -> goodEvilString = goodEvilChoiceBox.getValue());
        HBox alignmentHBox = new HBox(new Label("Alignment: "), lawfulChaoticChoiceBox, goodEvilChoiceBox);
        alignmentHBox.setSpacing(10);
        characterCustomizerAttributesVBox = new VBox(nameHBox, genderHBox, raceHBox, subraceHBox, playerClassHBox, subclassHBox, backgroundHBox, alignmentHBox, cantripsHBox, spellsHBox);
        characterCustomizerAttributesVBox.setSpacing(10);

        Label infoHeaderLabel = new Label("Character Info");
        infoHeaderLabel.getStyleClass().add("header-label");
        VBox characterCustomizerVBox = new VBox(infoHeaderLabel, characterCustomizerAttributesVBox);
        characterCustomizerVBox.setSpacing(20);
        characterCustomizerVBox.setAlignment(Pos.TOP_CENTER);

        Label abilityHeaderLabel = new Label("Abilities");
        abilityHeaderLabel.getStyleClass().add("header-label");
        Label abilityPointsLabel = new Label("(" + Integer.toString(totalAbilityPoints) + "/27)");
        abilityPointsLabel.getStyleClass().add("header-label");
        HBox abilityHeaderHBox = new HBox(abilityHeaderLabel, abilityPointsLabel);
        abilityHeaderHBox.setSpacing(20);
        abilityHeaderHBox.setAlignment(Pos.CENTER);
        strengthHBox.getDecreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = strengthHBox.decrease(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
            if (strengthHBox.getModifier() + athleticsHBox.getRaceBonus() + athleticsHBox.getSelectBonus() + athleticsHBox.getBackgroundBonus() >= 0) athleticsHBox.getModifierLabel().setText("+" + Integer.toString(strengthHBox.getModifier() + athleticsHBox.getRaceBonus() + athleticsHBox.getSelectBonus() + athleticsHBox.getBackgroundBonus()));
            else athleticsHBox.getModifierLabel().setText(Integer.toString(strengthHBox.getModifier() + athleticsHBox.getRaceBonus() + athleticsHBox.getSelectBonus() + athleticsHBox.getBackgroundBonus()));
        });
        strengthHBox.getIncreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = strengthHBox.increase(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
            if (strengthHBox.getModifier() + athleticsHBox.getRaceBonus() + athleticsHBox.getSelectBonus() + athleticsHBox.getBackgroundBonus() >= 0) athleticsHBox.getModifierLabel().setText("+" + Integer.toString(strengthHBox.getModifier() + athleticsHBox.getRaceBonus() + athleticsHBox.getSelectBonus() + athleticsHBox.getBackgroundBonus()));
            else athleticsHBox.getModifierLabel().setText(Integer.toString(strengthHBox.getModifier() + athleticsHBox.getRaceBonus() + athleticsHBox.getSelectBonus() + athleticsHBox.getBackgroundBonus()));
        });
        strengthHBox.getOneBonusCheckBox().setOnAction(event -> selectOneBonusCheckBox(strengthHBox));
        strengthHBox.getTwoBonusCheckBox().setOnAction(event -> selectTwoBonusCheckBox(strengthHBox));
        dexterityHBox.getDecreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = dexterityHBox.decrease(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
            if (dexterityHBox.getModifier() + acrobaticsHBox.getRaceBonus() + acrobaticsHBox.getSelectBonus() + acrobaticsHBox.getBackgroundBonus() >= 0) acrobaticsHBox.getModifierLabel().setText("+" + Integer.toString(dexterityHBox.getModifier() + acrobaticsHBox.getRaceBonus() + acrobaticsHBox.getSelectBonus() + acrobaticsHBox.getBackgroundBonus()));
            else acrobaticsHBox.getModifierLabel().setText(Integer.toString(dexterityHBox.getModifier() + acrobaticsHBox.getRaceBonus() + acrobaticsHBox.getSelectBonus() + acrobaticsHBox.getBackgroundBonus()));
            if (dexterityHBox.getModifier() + sleightOfHandHBox.getRaceBonus() + sleightOfHandHBox.getSelectBonus() + sleightOfHandHBox.getBackgroundBonus() >= 0) sleightOfHandHBox.getModifierLabel().setText("+" + Integer.toString(dexterityHBox.getModifier() + sleightOfHandHBox.getRaceBonus() + sleightOfHandHBox.getSelectBonus() + sleightOfHandHBox.getBackgroundBonus()));
            else sleightOfHandHBox.getModifierLabel().setText(Integer.toString(dexterityHBox.getModifier() + sleightOfHandHBox.getRaceBonus() + sleightOfHandHBox.getSelectBonus() + sleightOfHandHBox.getBackgroundBonus()));
            if (dexterityHBox.getModifier() + stealthHBox.getRaceBonus() + stealthHBox.getSelectBonus() + stealthHBox.getBackgroundBonus() >= 0) stealthHBox.getModifierLabel().setText("+" + Integer.toString(dexterityHBox.getModifier() + stealthHBox.getRaceBonus() + stealthHBox.getSelectBonus() + stealthHBox.getBackgroundBonus()));
            else stealthHBox.getModifierLabel().setText(Integer.toString(dexterityHBox.getModifier() + stealthHBox.getRaceBonus() + stealthHBox.getSelectBonus() + stealthHBox.getBackgroundBonus()));
        });
        dexterityHBox.getIncreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = dexterityHBox.increase(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
            if (dexterityHBox.getModifier() + acrobaticsHBox.getRaceBonus() + acrobaticsHBox.getSelectBonus() + acrobaticsHBox.getBackgroundBonus() >= 0) acrobaticsHBox.getModifierLabel().setText("+" + Integer.toString(dexterityHBox.getModifier() + acrobaticsHBox.getRaceBonus() + acrobaticsHBox.getSelectBonus() + acrobaticsHBox.getBackgroundBonus()));
            else acrobaticsHBox.getModifierLabel().setText(Integer.toString(dexterityHBox.getModifier() + acrobaticsHBox.getRaceBonus() + acrobaticsHBox.getSelectBonus() + acrobaticsHBox.getBackgroundBonus()));
            if (dexterityHBox.getModifier() + sleightOfHandHBox.getRaceBonus() + sleightOfHandHBox.getSelectBonus() + sleightOfHandHBox.getBackgroundBonus() >= 0) sleightOfHandHBox.getModifierLabel().setText("+" + Integer.toString(dexterityHBox.getModifier() + sleightOfHandHBox.getRaceBonus() + sleightOfHandHBox.getSelectBonus() + sleightOfHandHBox.getBackgroundBonus()));
            else sleightOfHandHBox.getModifierLabel().setText(Integer.toString(dexterityHBox.getModifier() + sleightOfHandHBox.getRaceBonus() + sleightOfHandHBox.getSelectBonus() + sleightOfHandHBox.getBackgroundBonus()));
            if (dexterityHBox.getModifier() + stealthHBox.getRaceBonus() + stealthHBox.getSelectBonus() + stealthHBox.getBackgroundBonus() >= 0) stealthHBox.getModifierLabel().setText("+" + Integer.toString(dexterityHBox.getModifier() + stealthHBox.getRaceBonus() + stealthHBox.getSelectBonus() + stealthHBox.getBackgroundBonus()));
            else stealthHBox.getModifierLabel().setText(Integer.toString(dexterityHBox.getModifier() + stealthHBox.getRaceBonus() + stealthHBox.getSelectBonus() + stealthHBox.getBackgroundBonus()));
        });
        dexterityHBox.getOneBonusCheckBox().setOnAction(event -> selectOneBonusCheckBox(dexterityHBox));
        dexterityHBox.getTwoBonusCheckBox().setOnAction(event -> selectTwoBonusCheckBox(dexterityHBox));
        constitutionHBox.getDecreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = constitutionHBox.decrease(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
        });
        constitutionHBox.getIncreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = constitutionHBox.increase(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
        });
        constitutionHBox.getOneBonusCheckBox().setOnAction(event -> selectOneBonusCheckBox(constitutionHBox));
        constitutionHBox.getTwoBonusCheckBox().setOnAction(event -> selectTwoBonusCheckBox(constitutionHBox));
        intelligenceHBox.getDecreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = intelligenceHBox.decrease(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
            if (intelligenceHBox.getModifier() + arcanaHBox.getRaceBonus() + arcanaHBox.getSelectBonus() + arcanaHBox.getBackgroundBonus() >= 0) arcanaHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + arcanaHBox.getRaceBonus() + arcanaHBox.getSelectBonus() + arcanaHBox.getBackgroundBonus()));
            else arcanaHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + arcanaHBox.getRaceBonus() + arcanaHBox.getSelectBonus() + arcanaHBox.getBackgroundBonus()));
            if (intelligenceHBox.getModifier() + historyHBox.getRaceBonus() + historyHBox.getSelectBonus() + historyHBox.getBackgroundBonus() >= 0) historyHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + historyHBox.getRaceBonus() + historyHBox.getSelectBonus() + historyHBox.getBackgroundBonus()));
            else historyHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + historyHBox.getRaceBonus() + historyHBox.getSelectBonus() + historyHBox.getBackgroundBonus()));
            if (intelligenceHBox.getModifier() + investigationHBox.getRaceBonus() + investigationHBox.getSelectBonus() + investigationHBox.getBackgroundBonus() >= 0) investigationHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + investigationHBox.getRaceBonus() + investigationHBox.getSelectBonus() + investigationHBox.getBackgroundBonus()));
            else investigationHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + investigationHBox.getRaceBonus() + investigationHBox.getSelectBonus() + investigationHBox.getBackgroundBonus()));
            if (intelligenceHBox.getModifier() + natureHBox.getRaceBonus() + natureHBox.getSelectBonus() + natureHBox.getBackgroundBonus() >= 0) natureHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + natureHBox.getRaceBonus() + natureHBox.getSelectBonus() + natureHBox.getBackgroundBonus()));
            else natureHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + natureHBox.getRaceBonus() + natureHBox.getSelectBonus() + natureHBox.getBackgroundBonus()));
            if (intelligenceHBox.getModifier() + religionHBox.getRaceBonus() + religionHBox.getSelectBonus() + religionHBox.getBackgroundBonus() >= 0) religionHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + religionHBox.getRaceBonus() + religionHBox.getSelectBonus() + religionHBox.getBackgroundBonus()));
            else religionHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + religionHBox.getRaceBonus() + religionHBox.getSelectBonus() + religionHBox.getBackgroundBonus()));
        });
        intelligenceHBox.getIncreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = intelligenceHBox.increase(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
            if (intelligenceHBox.getModifier() + arcanaHBox.getRaceBonus() + arcanaHBox.getSelectBonus() + arcanaHBox.getBackgroundBonus() >= 0) arcanaHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + arcanaHBox.getRaceBonus() + arcanaHBox.getSelectBonus() + arcanaHBox.getBackgroundBonus()));
            else arcanaHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + arcanaHBox.getRaceBonus() + arcanaHBox.getSelectBonus() + arcanaHBox.getBackgroundBonus()));
            if (intelligenceHBox.getModifier() + historyHBox.getRaceBonus() + historyHBox.getSelectBonus() + historyHBox.getBackgroundBonus() >= 0) historyHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + historyHBox.getRaceBonus() + historyHBox.getSelectBonus() + historyHBox.getBackgroundBonus()));
            else historyHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + historyHBox.getRaceBonus() + historyHBox.getSelectBonus() + historyHBox.getBackgroundBonus()));
            if (intelligenceHBox.getModifier() + investigationHBox.getRaceBonus() + investigationHBox.getSelectBonus() + investigationHBox.getBackgroundBonus() >= 0) investigationHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + investigationHBox.getRaceBonus() + investigationHBox.getSelectBonus() + investigationHBox.getBackgroundBonus()));
            else investigationHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + investigationHBox.getRaceBonus() + investigationHBox.getSelectBonus() + investigationHBox.getBackgroundBonus()));
            if (intelligenceHBox.getModifier() + natureHBox.getRaceBonus() + natureHBox.getSelectBonus() + natureHBox.getBackgroundBonus() >= 0) natureHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + natureHBox.getRaceBonus() + natureHBox.getSelectBonus() + natureHBox.getBackgroundBonus()));
            else natureHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + natureHBox.getRaceBonus() + natureHBox.getSelectBonus() + natureHBox.getBackgroundBonus()));
            if (intelligenceHBox.getModifier() + religionHBox.getRaceBonus() + religionHBox.getSelectBonus() + religionHBox.getBackgroundBonus() >= 0) religionHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + religionHBox.getRaceBonus() + religionHBox.getSelectBonus() + religionHBox.getBackgroundBonus()));
            else religionHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + religionHBox.getRaceBonus() + religionHBox.getSelectBonus() + religionHBox.getBackgroundBonus()));
        });
        intelligenceHBox.getOneBonusCheckBox().setOnAction(event -> selectOneBonusCheckBox(intelligenceHBox));
        intelligenceHBox.getTwoBonusCheckBox().setOnAction(event -> selectTwoBonusCheckBox(intelligenceHBox));
        wisdomHBox.getDecreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = wisdomHBox.decrease(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
            if (wisdomHBox.getModifier() + animalHandlingHBox.getRaceBonus() + animalHandlingHBox.getSelectBonus() + animalHandlingHBox.getBackgroundBonus() >= 0) animalHandlingHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + animalHandlingHBox.getRaceBonus() + animalHandlingHBox.getSelectBonus() + animalHandlingHBox.getBackgroundBonus()));
            else animalHandlingHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + animalHandlingHBox.getRaceBonus() + animalHandlingHBox.getSelectBonus() + animalHandlingHBox.getBackgroundBonus()));
            if (wisdomHBox.getModifier() + insightHBox.getRaceBonus() + insightHBox.getSelectBonus() + insightHBox.getBackgroundBonus() >= 0) insightHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + insightHBox.getRaceBonus() + insightHBox.getSelectBonus() + insightHBox.getBackgroundBonus()));
            else insightHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + insightHBox.getRaceBonus() + insightHBox.getSelectBonus() + insightHBox.getBackgroundBonus()));
            if (wisdomHBox.getModifier() + medicineHBox.getRaceBonus() + medicineHBox.getSelectBonus() + medicineHBox.getBackgroundBonus() >= 0) medicineHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + medicineHBox.getRaceBonus() + medicineHBox.getSelectBonus() + medicineHBox.getBackgroundBonus()));
            else medicineHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + medicineHBox.getRaceBonus() + medicineHBox.getSelectBonus() + medicineHBox.getBackgroundBonus()));
            if (wisdomHBox.getModifier() + perceptionHBox.getRaceBonus() + perceptionHBox.getSelectBonus() + perceptionHBox.getBackgroundBonus() >= 0) perceptionHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + perceptionHBox.getRaceBonus() + perceptionHBox.getSelectBonus() + perceptionHBox.getBackgroundBonus()));
            else perceptionHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + perceptionHBox.getRaceBonus() + perceptionHBox.getSelectBonus() + perceptionHBox.getBackgroundBonus()));
            if (wisdomHBox.getModifier() + survivalHBox.getRaceBonus() + survivalHBox.getSelectBonus() + survivalHBox.getBackgroundBonus() >= 0) survivalHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + survivalHBox.getRaceBonus() + survivalHBox.getSelectBonus() + survivalHBox.getBackgroundBonus()));
            else survivalHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + survivalHBox.getRaceBonus() + survivalHBox.getSelectBonus() + survivalHBox.getBackgroundBonus()));
        });
        wisdomHBox.getIncreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = wisdomHBox.increase(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
            if (wisdomHBox.getModifier() + animalHandlingHBox.getRaceBonus() + animalHandlingHBox.getSelectBonus() + animalHandlingHBox.getBackgroundBonus() >= 0) animalHandlingHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + animalHandlingHBox.getRaceBonus() + animalHandlingHBox.getSelectBonus() + animalHandlingHBox.getBackgroundBonus()));
            else animalHandlingHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + animalHandlingHBox.getRaceBonus() + animalHandlingHBox.getSelectBonus() + animalHandlingHBox.getBackgroundBonus()));
            if (wisdomHBox.getModifier() + insightHBox.getRaceBonus() + insightHBox.getSelectBonus() + insightHBox.getBackgroundBonus() >= 0) insightHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + insightHBox.getRaceBonus() + insightHBox.getSelectBonus() + insightHBox.getBackgroundBonus()));
            else insightHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + insightHBox.getRaceBonus() + insightHBox.getSelectBonus() + insightHBox.getBackgroundBonus()));
            if (wisdomHBox.getModifier() + medicineHBox.getRaceBonus() + medicineHBox.getSelectBonus() + medicineHBox.getBackgroundBonus() >= 0) medicineHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + medicineHBox.getRaceBonus() + medicineHBox.getSelectBonus() + medicineHBox.getBackgroundBonus()));
            else medicineHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + medicineHBox.getRaceBonus() + medicineHBox.getSelectBonus() + medicineHBox.getBackgroundBonus()));
            if (wisdomHBox.getModifier() + perceptionHBox.getRaceBonus() + perceptionHBox.getSelectBonus() + perceptionHBox.getBackgroundBonus() >= 0) perceptionHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + perceptionHBox.getRaceBonus() + perceptionHBox.getSelectBonus() + perceptionHBox.getBackgroundBonus()));
            else perceptionHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + perceptionHBox.getRaceBonus() + perceptionHBox.getSelectBonus() + perceptionHBox.getBackgroundBonus()));
            if (wisdomHBox.getModifier() + survivalHBox.getRaceBonus() + survivalHBox.getSelectBonus() + survivalHBox.getBackgroundBonus() >= 0) survivalHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + survivalHBox.getRaceBonus() + survivalHBox.getSelectBonus() + survivalHBox.getBackgroundBonus()));
            else survivalHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + survivalHBox.getRaceBonus() + survivalHBox.getSelectBonus() + survivalHBox.getBackgroundBonus()));
        });
        wisdomHBox.getOneBonusCheckBox().setOnAction(event -> selectOneBonusCheckBox(wisdomHBox));
        wisdomHBox.getTwoBonusCheckBox().setOnAction(event -> selectTwoBonusCheckBox(wisdomHBox));
        charismaHBox.getDecreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = charismaHBox.decrease(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
            if (charismaHBox.getModifier() + deceptionHBox.getRaceBonus() + deceptionHBox.getSelectBonus() + deceptionHBox.getBackgroundBonus() >= 0) deceptionHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + deceptionHBox.getRaceBonus() + deceptionHBox.getSelectBonus() + deceptionHBox.getBackgroundBonus()));
            else deceptionHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + deceptionHBox.getRaceBonus() + deceptionHBox.getSelectBonus() + deceptionHBox.getBackgroundBonus()));
            if (charismaHBox.getModifier() + intimidationHBox.getRaceBonus() + intimidationHBox.getSelectBonus() + intimidationHBox.getBackgroundBonus() >= 0) intimidationHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + intimidationHBox.getRaceBonus() + intimidationHBox.getSelectBonus() + intimidationHBox.getBackgroundBonus()));
            else intimidationHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + intimidationHBox.getRaceBonus() + intimidationHBox.getSelectBonus() + intimidationHBox.getBackgroundBonus()));
            if (charismaHBox.getModifier() + performanceHBox.getRaceBonus() + performanceHBox.getSelectBonus() + performanceHBox.getBackgroundBonus() >= 0) performanceHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + performanceHBox.getRaceBonus() + performanceHBox.getSelectBonus() + performanceHBox.getBackgroundBonus()));
            else performanceHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + performanceHBox.getRaceBonus() + performanceHBox.getSelectBonus() + performanceHBox.getBackgroundBonus()));
            if (charismaHBox.getModifier() + persuasionHBox.getRaceBonus() + persuasionHBox.getSelectBonus() + persuasionHBox.getBackgroundBonus() >= 0) persuasionHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + persuasionHBox.getRaceBonus() + persuasionHBox.getSelectBonus() + persuasionHBox.getBackgroundBonus()));
            else persuasionHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + persuasionHBox.getRaceBonus() + persuasionHBox.getSelectBonus() + persuasionHBox.getBackgroundBonus()));
        });
        charismaHBox.getIncreaseButton().getButton().setOnAction(event -> {
            totalAbilityPoints = charismaHBox.increase(totalAbilityPoints);
            abilityPointsLabel.setText("(" + Integer.toString(totalAbilityPoints) + "/27)");
            if (charismaHBox.getModifier() + deceptionHBox.getRaceBonus() + deceptionHBox.getSelectBonus() + deceptionHBox.getBackgroundBonus() >= 0) deceptionHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + deceptionHBox.getRaceBonus() + deceptionHBox.getSelectBonus() + deceptionHBox.getBackgroundBonus()));
            else deceptionHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + deceptionHBox.getRaceBonus() + deceptionHBox.getSelectBonus() + deceptionHBox.getBackgroundBonus()));
            if (charismaHBox.getModifier() + intimidationHBox.getRaceBonus() + intimidationHBox.getSelectBonus() + intimidationHBox.getBackgroundBonus() >= 0) intimidationHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + intimidationHBox.getRaceBonus() + intimidationHBox.getSelectBonus() + intimidationHBox.getBackgroundBonus()));
            else intimidationHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + intimidationHBox.getRaceBonus() + intimidationHBox.getSelectBonus() + intimidationHBox.getBackgroundBonus()));
            if (charismaHBox.getModifier() + performanceHBox.getRaceBonus() + performanceHBox.getSelectBonus() + performanceHBox.getBackgroundBonus() >= 0) performanceHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + performanceHBox.getRaceBonus() + performanceHBox.getSelectBonus() + performanceHBox.getBackgroundBonus()));
            else performanceHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + performanceHBox.getRaceBonus() + performanceHBox.getSelectBonus() + performanceHBox.getBackgroundBonus()));
            if (charismaHBox.getModifier() + persuasionHBox.getRaceBonus() + persuasionHBox.getSelectBonus() + persuasionHBox.getBackgroundBonus() >= 0) persuasionHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + persuasionHBox.getRaceBonus() + persuasionHBox.getSelectBonus() + persuasionHBox.getBackgroundBonus()));
            else persuasionHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + persuasionHBox.getRaceBonus() + persuasionHBox.getSelectBonus() + persuasionHBox.getBackgroundBonus()));
        });
        charismaHBox.getOneBonusCheckBox().setOnAction(event -> selectOneBonusCheckBox(charismaHBox));
        charismaHBox.getTwoBonusCheckBox().setOnAction(event -> selectTwoBonusCheckBox(charismaHBox));
        VBox abilitiesListVBox = new VBox(strengthHBox, dexterityHBox, constitutionHBox, intelligenceHBox, wisdomHBox, charismaHBox);
        abilitiesListVBox.setAlignment(Pos.CENTER);
        abilitiesListVBox.setSpacing(10);

        MenuButton skillsButton = new MenuButton("Select");
        HBox skillsHBox = new HBox(new Label("Skills: "), skillsButton);
        skillsHBox.setSpacing(20);
        skillsHBox.setAlignment(Pos.CENTER);
        Label backstoryLabel = new Label("Backstory");
        backstoryLabel.getStyleClass().add("header-label");
        MenuButton generateBackstoryButton = new MenuButton("Generate");
        MenuButton viewBackstoryButton = new MenuButton("View");
        viewBackstoryButton.setDisable(true);
        HBox backstoryHBox = new HBox(generateBackstoryButton, viewBackstoryButton);
        backstoryHBox.setSpacing(20);
        backstoryHBox.setAlignment(Pos.CENTER);
        VBox backstoryVBox = new VBox(backstoryLabel, backstoryHBox);
        backstoryVBox.setSpacing(20);
        backstoryVBox.setAlignment(Pos.CENTER);
        VBox characterAbilitiesVBox = new VBox(abilityHeaderHBox, abilitiesListVBox, skillsHBox, backstoryVBox);
        characterAbilitiesVBox.setAlignment(Pos.TOP_CENTER);
        characterAbilitiesVBox.setSpacing(20);
        HBox characterCustomizerHBox = new HBox(characterCustomizerVBox, characterAbilitiesVBox);
        characterCustomizerHBox.setSpacing(50);

        MasterButton characterSheetButton = new MasterButton("Character Sheet");
        characterSheetButton.setDisable(true);
        VBox characterBuilderVBox = new VBox(characterCustomizerHBox, characterSheetButton);
        characterBuilderVBox.setSpacing(40);
        characterBuilderVBox.setAlignment(Pos.CENTER);

        Group characterBuilderGroup = new Group(characterBuilderVBox);
        characterBuilderGroup.setTranslateY(25);
        StackPane characterBuilderStackPane = new StackPane(borderImageView, characterBuilderGroup);

        ImageView cantripsBorderImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/BackstoryBorder.png").toString()));
        cantripsBorderImageView.setFitWidth(700);
        cantripsBorderImageView.setFitHeight(875);
        Label cantripsLabel = new Label("Cantrips");
        cantripsLabel.getStyleClass().add("spells-header-label");
        Label raceCantripsLabel = new Label("Race");
        raceCantripsLabel.getStyleClass().add("spells-category-label");
        raceCantripPointsLabel = new Label("(" + remainingRaceCantrips + "/" + totalRaceCantrips + ")");
        raceCantripPointsLabel.getStyleClass().add("spells-category-label");
        HBox raceCantripsHBox = new HBox(raceCantripsLabel, raceCantripPointsLabel);
        raceCantripsHBox.setSpacing(20);
        raceCantripsHBox.setAlignment(Pos.CENTER);
        acidSplashRaceButton.getButton().setOnAction(event -> selectRaceCantrip(acidSplashRaceButton, acidSplashClassButton));
        bladeWardRaceButton.getButton().setOnAction(event -> selectRaceCantrip(bladeWardRaceButton, bladeWardClassButton));
        boneChillRaceButton.getButton().setOnAction(event -> selectRaceCantrip(boneChillRaceButton, boneChillClassButton));
        dancingLightsRaceButton.getButton().setOnAction(event -> selectRaceCantrip(dancingLightsRaceButton, dancingLightsClassButton));
        fireBoltRaceButton.getButton().setOnAction(event -> selectRaceCantrip(fireBoltRaceButton, fireBoltClassButton));
        friendsRaceButton.getButton().setOnAction(event -> selectRaceCantrip(friendsRaceButton, friendsClassButton));
        lightRaceButton.getButton().setOnAction(event -> selectRaceCantrip(lightRaceButton, lightClassButton));
        mageHandRaceButton.getButton().setOnAction(event -> selectRaceCantrip(mageHandRaceButton, mageHandClassButton));
        minorIllusionRaceButton.getButton().setOnAction(event -> selectRaceCantrip(minorIllusionRaceButton, minorIllusionClassButton));
        poisonSprayRaceButton.getButton().setOnAction(event -> selectRaceCantrip(poisonSprayRaceButton, poisonSprayClassButton));
        rayOfFrostRaceButton.getButton().setOnAction(event -> selectRaceCantrip(rayOfFrostRaceButton, rayOfFrostClassButton));
        shockingGraspRaceButton.getButton().setOnAction(event -> selectRaceCantrip(shockingGraspRaceButton, shockingGraspClassButton));
        trueStrikeRaceButton.getButton().setOnAction(event -> selectRaceCantrip(trueStrikeRaceButton, trueStrikeClassButton));
        produceFlameRaceButton.getButton().setOnAction(event -> selectRaceCantrip(produceFlameRaceButton, produceFlameClassButton));
        thaumaturgyRaceButton.getButton().setOnAction(event -> selectRaceCantrip(thaumaturgyRaceButton, thaumaturgyClassButton));
        githyankiMageHandButton.getButton().setOnAction(event -> selectRaceCantrip(githyankiMageHandButton, null));
        raceCantripsFlowPane = new FlowPane(acidSplashRaceButton, bladeWardRaceButton, boneChillRaceButton, dancingLightsRaceButton, fireBoltRaceButton, friendsRaceButton, lightRaceButton, mageHandRaceButton, minorIllusionRaceButton, poisonSprayRaceButton, rayOfFrostRaceButton, shockingGraspRaceButton, trueStrikeRaceButton);
        raceCantripsFlowPane.setAlignment(Pos.CENTER);
        raceCantripsFlowPane.setMaxWidth(600);
        VBox raceCantripsVBox = new VBox(raceCantripsHBox, raceCantripsFlowPane);
        raceCantripsVBox.setAlignment(Pos.CENTER);
        raceCantripsVBox.setSpacing(5);
        Label classCantripsLabel = new Label("Class");
        classCantripsLabel.getStyleClass().add("spells-category-label");
        classCantripPointsLabel = new Label("(" + remainingClassCantrips + "/" + totalClassCantrips + ")");
        classCantripPointsLabel.getStyleClass().add("spells-category-label");
        HBox classCantripsHBox = new HBox(classCantripsLabel, classCantripPointsLabel);
        classCantripsHBox.setAlignment(Pos.CENTER);
        classCantripsHBox.setSpacing(20);
        acidSplashClassButton.getButton().setOnAction(event -> selectClassCantrip(acidSplashClassButton, acidSplashRaceButton));
        bladeWardClassButton.getButton().setOnAction(event -> selectClassCantrip(bladeWardClassButton, bladeWardRaceButton));
        boneChillClassButton.getButton().setOnAction(event -> selectClassCantrip(boneChillClassButton, boneChillRaceButton));
        dancingLightsClassButton.getButton().setOnAction(event -> selectClassCantrip(dancingLightsClassButton, dancingLightsRaceButton));
        fireBoltClassButton.getButton().setOnAction(event -> selectClassCantrip(fireBoltClassButton, fireBoltRaceButton));
        friendsClassButton.getButton().setOnAction(event -> selectClassCantrip(friendsClassButton, friendsRaceButton));
        lightClassButton.getButton().setOnAction(event -> selectClassCantrip(lightClassButton, lightRaceButton));
        mageHandClassButton.getButton().setOnAction(event -> selectClassCantrip(mageHandClassButton, mageHandRaceButton));
        minorIllusionClassButton.getButton().setOnAction(event -> selectClassCantrip(minorIllusionClassButton, minorIllusionRaceButton));
        poisonSprayClassButton.getButton().setOnAction(event -> selectClassCantrip(poisonSprayClassButton, poisonSprayRaceButton));
        rayOfFrostClassButton.getButton().setOnAction(event -> selectClassCantrip(rayOfFrostClassButton, rayOfFrostRaceButton));
        shockingGraspClassButton.getButton().setOnAction(event -> selectClassCantrip(shockingGraspClassButton, shockingGraspRaceButton));
        trueStrikeClassButton.getButton().setOnAction(event -> selectClassCantrip(trueStrikeClassButton, trueStrikeRaceButton));
        viciousMockeryClassButton.getButton().setOnAction(event -> selectClassCantrip(viciousMockeryClassButton, null));
        thaumaturgyClassButton.getButton().setOnAction(event -> selectClassCantrip(thaumaturgyClassButton, thaumaturgyRaceButton));
        sacredFlameClassButton.getButton().setOnAction(event -> selectClassCantrip(sacredFlameClassButton, null));
        guidanceClassButton.getButton().setOnAction(event -> selectClassCantrip(guidanceClassButton, null));
        resistanceClassButton.getButton().setOnAction(event -> selectClassCantrip(resistanceClassButton, null));
        produceFlameClassButton.getButton().setOnAction(event -> selectClassCantrip(produceFlameClassButton, produceFlameRaceButton));
        shillelaghClassButton.getButton().setOnAction(event -> selectClassCantrip(shillelaghClassButton, null));
        thornWhipClassButton.getButton().setOnAction(event -> selectClassCantrip(thornWhipClassButton, null));
        eldritchBlastClassButton.getButton().setOnAction(event -> selectClassCantrip(eldritchBlastClassButton, null));
        classCantripsFlowPane.setAlignment(Pos.CENTER);
        classCantripsFlowPane.setMaxWidth((600));
        VBox classCantripsVBox = new VBox(classCantripsHBox, classCantripsFlowPane);
        classCantripsVBox.setAlignment(Pos.CENTER);
        classCantripsVBox.setSpacing(5);
        MenuButton cantripsConfirmButton = new MenuButton("Confirm");
        VBox cantripsVBox = new VBox(cantripsLabel, raceCantripsVBox, classCantripsVBox, cantripsConfirmButton);
        cantripsVBox.setSpacing(20);
        cantripsVBox.setAlignment(Pos.CENTER);
        StackPane cantripsStackPane = new StackPane(cantripsBorderImageView, cantripsVBox);

        ImageView spellsBorderImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/BackstoryBorder.png").toString()));
        spellsBorderImageView.setFitWidth(700);
        spellsBorderImageView.setFitHeight(875);
        Label spellsLabel = new Label("Spells");
        spellsLabel.getStyleClass().add("spells-category-label");
        spellsPointsLabel.getStyleClass().add("spells-category-label");
        HBox spellsHeaderHBox = new HBox(spellsLabel, spellsPointsLabel);
        spellsHeaderHBox.setSpacing(20);
        spellsHeaderHBox.setAlignment(Pos.CENTER);
        animalFriendshipSpellButton.getButton().setOnAction(event -> selectSpell(animalFriendshipSpellButton));
        armourOfAgathysSpellButton.getButton().setOnAction(event -> selectSpell(armourOfAgathysSpellButton));
        armsOfHadarSpellButton.getButton().setOnAction(event -> selectSpell(armsOfHadarSpellButton));
        baneSpellButton.getButton().setOnAction(event -> selectSpell(baneSpellButton));
        burningHandsSpellButton.getButton().setOnAction(event -> selectSpell(burningHandsSpellButton));
        charmPersonSpellButton.getButton().setOnAction(event -> selectSpell(charmPersonSpellButton));
        chromaticOrbSpellButton.getButton().setOnAction(event -> selectSpell(chromaticOrbSpellButton));
        colourSpraySpellButton.getButton().setOnAction(event -> selectSpell(colourSpraySpellButton));
        commandSpellButton.getButton().setOnAction(event -> selectSpell(commandSpellButton));
        cureWoundsSpellButton.getButton().setOnAction(event -> selectSpell(cureWoundsSpellButton));
        disguiseSelfSpellButton.getButton().setOnAction(event -> selectSpell(disguiseSelfSpellButton));
        dissonantWhispersSpellButton.getButton().setOnAction(event -> selectSpell(dissonantWhispersSpellButton));
        divineFavourSpellButton.getButton().setOnAction(event -> selectSpell(divineFavourSpellButton));
        enhanceLeapSpellButton.getButton().setOnAction(event -> selectSpell(enhanceLeapSpellButton));
        expeditiousRetreatSpellButton.getButton().setOnAction(event ->selectSpell(expeditiousRetreatSpellButton));
        faerieFireSpellButton.getButton().setOnAction(event -> selectSpell(faerieFireSpellButton));
        falseLifeSpellButton.getButton().setOnAction(event -> selectSpell(falseLifeSpellButton));
        featherFallSpellButton.getButton().setOnAction(event -> selectSpell(featherFallSpellButton));
        findFamiliarSpellButton.getButton().setOnAction(event -> selectSpell(findFamiliarSpellButton));
        fogCloudSpellButton.getButton().setOnAction(event -> selectSpell(fogCloudSpellButton));
        greaseSpellButton.getButton().setOnAction(event -> selectSpell(greaseSpellButton));
        guidingBoltSpellButton.getButton().setOnAction(event -> selectSpell(guidingBoltSpellButton));
        healingWordSpellButton.getButton().setOnAction(event -> selectSpell(healingWordSpellButton));
        hellishRebukeSpellButton.getButton().setOnAction(event -> selectSpell(hellishRebukeSpellButton));
        heroismSpellButton.getButton().setOnAction(event -> selectSpell(heroismSpellButton));
        iceKnifeSpellButton.getButton().setOnAction(event -> selectSpell(iceKnifeSpellButton));
        inflictWoundsSpellButton.getButton().setOnAction(event -> selectSpell(inflictWoundsSpellButton));
        longstriderSpellButton.getButton().setOnAction(event -> selectSpell(longstriderSpellButton));
        mageArmourSpellButton.getButton().setOnAction(event -> selectSpell(mageArmourSpellButton));
        magicMissileSpellButton.getButton().setOnAction(event -> selectSpell(magicMissileSpellButton));
        protectionFromEvilAndGoodSpellButton.getButton().setOnAction(event -> selectSpell(protectionFromEvilAndGoodSpellButton));
        rayOfSicknessSpellButton.getButton().setOnAction(event -> selectSpell(rayOfSicknessSpellButton));
        shieldSpellButton.getButton().setOnAction(event -> selectSpell(shieldSpellButton));
        shieldOfFaithSpellButton.getButton().setOnAction(event -> selectSpell(shieldOfFaithSpellButton));
        sleepSpellButton.getButton().setOnAction(event -> selectSpell(sleepSpellButton));
        speakWithAnimalsSpellButton.getButton().setOnAction(event -> selectSpell(speakWithAnimalsSpellButton));
        tashasHideousLaughterSpellButton.getButton().setOnAction(event -> selectSpell(tashasHideousLaughterSpellButton));
        thunderwaveSpellButton.getButton().setOnAction(event -> selectSpell(thunderwaveSpellButton));
        witchboltSpellButton.getButton().setOnAction(event -> selectSpell(witchboltSpellButton));
        sanctuarySpellButton.getButton().setOnAction(event -> selectSpell(sanctuarySpellButton));
        blessSpellButton.getButton().setOnAction(event -> selectSpell(blessSpellButton));
        createOrDestroyWaterSpellButton.getButton().setOnAction(event -> selectSpell(createOrDestroyWaterSpellButton));
        goodberrySpellButton.getButton().setOnAction(event -> selectSpell(goodberrySpellButton));
        hexSpellButton.getButton().setOnAction(event -> selectSpell(hexSpellButton));
        entangleSpellButton.getButton().setOnAction(event -> selectSpell(entangleSpellButton));
        spellsFlowPane.setAlignment(Pos.CENTER);
        spellsFlowPane.setMaxWidth(600);
        MenuButton spellsConfirmButton = new MenuButton("Confirm");
        VBox spellsVBox = new VBox(spellsHeaderHBox, spellsFlowPane, spellsConfirmButton);
        spellsVBox.setSpacing(30);
        spellsVBox.setAlignment(Pos.CENTER);
        StackPane spellsStackPane = new StackPane(spellsBorderImageView, spellsVBox);

        ImageView skillsBorderImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/SkillsBorder.png").toString()));
        skillsBorderImageView.setFitHeight(700);
        skillsBorderImageView.setPreserveRatio(true);
        Label skillsLabel = new Label("Skills");
        skillsLabel.getStyleClass().add("header-label");
        HBox skillsHeaderHBox = new HBox(skillsLabel, skillPointsLabel);
        skillsHeaderHBox.setSpacing(20);
        skillsHeaderHBox.setAlignment(Pos.CENTER);
        athleticsHBox.getSkillCheckBox().setOnAction(event -> selectSkill(athleticsHBox));
        acrobaticsHBox.getSkillCheckBox().setOnAction(event -> selectSkill(acrobaticsHBox));
        sleightOfHandHBox.getSkillCheckBox().setOnAction(event -> selectSkill(sleightOfHandHBox));
        stealthHBox.getSkillCheckBox().setOnAction(event -> selectSkill(stealthHBox));
        arcanaHBox.getSkillCheckBox().setOnAction(event -> selectSkill(arcanaHBox));
        historyHBox.getSkillCheckBox().setOnAction(event -> selectSkill(historyHBox));
        investigationHBox.getSkillCheckBox().setOnAction(event -> selectSkill(investigationHBox));
        natureHBox.getSkillCheckBox().setOnAction(event -> selectSkill(natureHBox));
        religionHBox.getSkillCheckBox().setOnAction(event -> selectSkill(religionHBox));
        animalHandlingHBox.getSkillCheckBox().setOnAction(event -> selectSkill(animalHandlingHBox));
        insightHBox.getSkillCheckBox().setOnAction(event -> selectSkill(insightHBox));
        medicineHBox.getSkillCheckBox().setOnAction(event -> selectSkill(medicineHBox));
        perceptionHBox.getSkillCheckBox().setOnAction(event -> selectSkill(perceptionHBox));
        survivalHBox.getSkillCheckBox().setOnAction(event -> selectSkill(survivalHBox));
        deceptionHBox.getSkillCheckBox().setOnAction(event -> selectSkill(deceptionHBox));
        intimidationHBox.getSkillCheckBox().setOnAction(event -> selectSkill(intimidationHBox));
        performanceHBox.getSkillCheckBox().setOnAction(event -> selectSkill(performanceHBox));
        persuasionHBox.getSkillCheckBox().setOnAction(event -> selectSkill(persuasionHBox));
        VBox skillsListVBox = new VBox(athleticsHBox, acrobaticsHBox, sleightOfHandHBox, stealthHBox, arcanaHBox, historyHBox, investigationHBox, natureHBox, religionHBox, animalHandlingHBox, insightHBox, medicineHBox, perceptionHBox, survivalHBox, deceptionHBox, intimidationHBox, performanceHBox, persuasionHBox);
        skillsListVBox.setSpacing(5);
        skillsListVBox.setAlignment(Pos.CENTER);
        MenuButton skillsConfirmButton = new MenuButton("Confirm");
        VBox skillsVBox = new VBox(skillsHeaderHBox, skillsListVBox, skillsConfirmButton);
        skillsVBox.setSpacing(15);
        skillsVBox.setAlignment(Pos.CENTER);
        StackPane skillsStackPane = new StackPane(skillsBorderImageView, skillsVBox);

        ImageView backstoryBorderImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/BackstoryBorder.png").toString()));
        backstoryBorderImageView.setFitWidth(700);
        backstoryBorderImageView.setPreserveRatio(true);
        VBox backstoryParagraphVBox = new VBox();
        backstoryParagraphVBox.setSpacing(3);
        backstoryParagraphVBox.setAlignment(Pos.CENTER);
        MenuButton backstoryPanelButton = new MenuButton("Continue");
        VBox backstoryPanelVBox = new VBox(backstoryParagraphVBox, backstoryPanelButton);
        backstoryPanelVBox.setSpacing(30);
        backstoryPanelVBox.setAlignment(Pos.CENTER);
        backstoryPanelVBox.setTranslateY(10);
        StackPane backstoryPanelStackPane = new StackPane(backstoryBorderImageView, backstoryPanelVBox);
        generateBackstoryButton.getButton().setOnAction(event -> {
            playerName = nameTextField.getText();
            backstoryParagraph.clear();
            backstoryLabelList.clear();
            backstoryParagraphVBox.getChildren().clear();
            if (playerClass == "Cleric") backstoryString = chatGPT("Write a short backstory for " + playerName + ", a " + lawfulChaoticString + " " + goodEvilString + " " + gender + " " + subrace + " " + subclass + " " + playerClass + " " + background + " from Baldur's Gate who worships " + deity + "in less than 100 words.");
            else backstoryString = chatGPT("Write a short backstory for " + playerName + ", a " + lawfulChaoticString + " " + goodEvilString + " " + gender + " " + subrace + " " + subclass + " " + playerClass + " " + background + " from Baldur's Gate in less than 100 words.");
            tempString = "";
            tempInt = 0;
            for (int i = 0; i < backstoryString.length(); i++) {
                if (backstoryString.charAt(i) == '\\' || i == (backstoryString.length() - 1)) {
                    tempString = tempString + backstoryString.substring(tempInt, i) + ". ";
                    i = i + 4;
                    tempInt = i;
                }
            }
            backstoryString = tempString;
            tempString = "";
            for (int i = 0; i < backstoryString.length(); i++) {
                tempString = tempString + backstoryString.charAt(i);
                if (tempString.length() >= 75 && backstoryString.charAt(i) == ' ') {
                    backstoryParagraph.add(tempString);
                    tempString = "";
                }
            }
            backstoryParagraph.add(tempString);
            for (int i = 0; i < backstoryParagraph.size(); i++) {
                backstoryLabelList.add(new Label(backstoryParagraph.get(i)));
                backstoryLabelList.get(i).getStyleClass().add("backstory-label");
            }
            tempString = "";
            tempInt = 0;
            for (int i = 0; i < backstoryParagraph.size(); i++) backstoryParagraphVBox.getChildren().add(backstoryLabelList.get(i));
            viewBackstoryButton.setDisable(false);
            characterSheetButton.setDisable(false);
        });

        ImageView characterSheetBorderImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/Paper.png").toString()));
        characterSheetBorderImageView.setFitWidth(1100);
        characterSheetBorderImageView.setFitHeight(750);

        ImageView characterSheetInfoImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/Tapestry.png").toString()));
        characterSheetInfoImageView.setFitWidth(260);
        characterSheetInfoImageView.setFitHeight(230);
        characterSheetInfoImageView.setTranslateY(15);
        Label characterSheetInfoLabel = new Label("Character Info");
        characterSheetInfoLabel.getStyleClass().add("tapestry-header-label");
        Label characterSheetNameListLabel = new Label ("Name: ");
        characterSheetNameListLabel.getStyleClass().add("tapestry-label");
        Label characterSheetRaceListLabel = new Label ("Race: ");
        characterSheetRaceListLabel.getStyleClass().add("tapestry-label");
        Label characterSheetClassListLabel = new Label("Class: ");
        characterSheetClassListLabel.getStyleClass().add("tapestry-label");
        Label characterSheetBackgroundListLabel = new Label("Background: ");
        characterSheetBackgroundListLabel.getStyleClass().add("tapestry-label");
        Label characterSheetAlignmentListLabel = new Label("Alignment: ");
        characterSheetAlignmentListLabel.getStyleClass().add("tapestry-label");
        characterSheetNameValueLabel.getStyleClass().add("tapestry-label");
        characterSheetRaceValueLabel.getStyleClass().add("tapestry-label");
        characterSheetClassValueLabel.getStyleClass().add("tapestry-label");
        characterSheetBackgroundValueLabel.getStyleClass().add("tapestry-label");
        characterSheetAlignmentValueLabel.getStyleClass().add("tapestry-label");
        HBox characterSheetNameHBox = new HBox(characterSheetNameListLabel, characterSheetNameValueLabel);
        characterSheetNameHBox.setSpacing(10);
        characterSheetNameHBox.setAlignment(Pos.CENTER);
        HBox characterSheetRaceHBox = new HBox(characterSheetRaceListLabel, characterSheetRaceValueLabel);
        characterSheetRaceHBox.setSpacing(10);
        characterSheetRaceHBox.setAlignment(Pos.CENTER);
        HBox characterSheetClassHBox = new HBox(characterSheetClassListLabel, characterSheetClassValueLabel);
        characterSheetClassHBox.setSpacing(10);
        characterSheetClassHBox.setAlignment(Pos.CENTER);
        HBox characterSheetBackgroundHBox = new HBox(characterSheetBackgroundListLabel, characterSheetBackgroundValueLabel);
        characterSheetBackgroundHBox.setSpacing(10);
        characterSheetBackgroundHBox.setAlignment(Pos.CENTER);
        HBox characterSheetAlignmentHBox = new HBox(characterSheetAlignmentListLabel, characterSheetAlignmentValueLabel);
        characterSheetAlignmentHBox.setSpacing(10);
        characterSheetAlignmentHBox.setAlignment(Pos.CENTER);
        VBox characterSheetInfoListVBox = new VBox(characterSheetNameHBox, characterSheetRaceHBox, characterSheetClassHBox, characterSheetBackgroundHBox, characterSheetAlignmentHBox);
        characterSheetInfoListVBox.setAlignment(Pos.CENTER);
        VBox characterSheetInfoVBox = new VBox(characterSheetInfoLabel, characterSheetInfoListVBox);
        characterSheetInfoVBox.setAlignment(Pos.CENTER);
        StackPane characterSheetInfoStackPane = new StackPane(characterSheetInfoImageView, characterSheetInfoVBox);

        Label characterSheetBackstoryLabel = new Label("Backstory");
        characterSheetBackstoryLabel.getStyleClass().add("cs-backstory-label");
        VBox characterSheetBackstoryVBox = new VBox(characterSheetBackstoryLabel, characterSheetBackstoryParagraphVBox);
        characterSheetBackstoryVBox.setAlignment(Pos.CENTER);

        VBox characterSheetColumn1VBox = new VBox(characterSheetInfoStackPane, characterSheetBackstoryVBox);
        characterSheetColumn1VBox.setAlignment(Pos.CENTER);
        characterSheetColumn1VBox.setSpacing(20);

        Label characterSheetStatsLabel = new Label("Stats");
        characterSheetStatsLabel.getStyleClass().add("cs-header-label");
        Label characterSheetHPListLabel = new Label("Hit Points");
        characterSheetHPListLabel.getStyleClass().add("cs-label");
        Label characterSheetACListLabel = new Label("Armour Class");
        characterSheetACListLabel.getStyleClass().add("cs-label");
        Label characterSheetSpeedLabel = new Label("Speed");
        characterSheetSpeedLabel.getStyleClass().add("cs-label");
        Label characterSheetInitiativeLabel = new Label("Initiative");
        characterSheetInitiativeLabel.getStyleClass().add("cs-label");
        Label characterSheetCarryLabel = new Label("Carrying Capacity");
        characterSheetCarryLabel.getStyleClass().add("cs-label");
        VBox characterSheetStatsListVBox = new VBox(characterSheetHPListLabel, characterSheetACListLabel, characterSheetSpeedLabel, characterSheetInitiativeLabel, characterSheetCarryLabel);
        characterSheetStatsListVBox.setAlignment(Pos.TOP_LEFT);
        characterSheetHPValueLabel.getStyleClass().add("cs-label");
        characterSheetACValueLabel.getStyleClass().add("cs-label");
        characterSheetSpeedValueLabel.getStyleClass().add("cs-label");
        characterSheetInitiativeValueLabel.getStyleClass().add("cs-label");
        characterSheetCarryValueLabel.getStyleClass().add("cs-label");
        VBox characterSheetStatsValuesVBox = new VBox(characterSheetHPValueLabel, characterSheetACValueLabel, characterSheetSpeedValueLabel, characterSheetInitiativeValueLabel, characterSheetCarryValueLabel);
        characterSheetStatsValuesVBox.setAlignment(Pos.CENTER);
        HBox characterSheetStatsHBox = new HBox(characterSheetStatsListVBox, characterSheetStatsValuesVBox);
        characterSheetStatsHBox.setSpacing(50);
        characterSheetStatsHBox.setAlignment(Pos.CENTER);
        VBox characterSheetStatsVBox = new VBox(characterSheetStatsLabel, characterSheetStatsHBox);
        characterSheetStatsVBox.setAlignment(Pos.CENTER);

        Label characterSheetAbilitiesLabel = new Label("Abilities");
        characterSheetAbilitiesLabel.getStyleClass().add("cs-header-label");
        Label characterSheetStrengthLabel = new Label("Strength");
        characterSheetStrengthLabel.getStyleClass().add("cs-label");
        Label characterSheetDexterityLabel = new Label("Dexterity");
        characterSheetDexterityLabel.getStyleClass().add("cs-label");
        Label characterSheetConstitutionLabel = new Label("Constitution");
        characterSheetConstitutionLabel.getStyleClass().add("cs-label");
        Label characterSheetIntelligenceLabel = new Label("Intelligence");
        characterSheetIntelligenceLabel.getStyleClass().add("cs-label");
        Label characterSheetWisdomLabel = new Label("Wisdom");
        characterSheetWisdomLabel.getStyleClass().add("cs-label");
        Label characterSheetCharismaLabel = new Label("Charisma");
        characterSheetCharismaLabel.getStyleClass().add("cs-label");
        VBox characterSheetAbilitiesListVBox = new VBox(characterSheetStrengthLabel, characterSheetDexterityLabel, characterSheetConstitutionLabel, characterSheetIntelligenceLabel, characterSheetWisdomLabel, characterSheetCharismaLabel);
        characterSheetAbilitiesListVBox.setAlignment(Pos.TOP_LEFT);
        characterSheetStrengthValueLabel.getStyleClass().add("cs-label");
        characterSheetDexterityValueLabel.getStyleClass().add("cs-label");
        characterSheetConstitutionValueLabel.getStyleClass().add("cs-label");
        characterSheetIntelligenceValueLabel.getStyleClass().add("cs-label");
        characterSheetWisdomValueLabel.getStyleClass().add("cs-label");
        characterSheetCharismaValueLabel.getStyleClass().add("cs-label");
        VBox characterSheetAbilitiesValuesVBox = new VBox(characterSheetStrengthValueLabel, characterSheetDexterityValueLabel, characterSheetConstitutionValueLabel, characterSheetIntelligenceValueLabel, characterSheetWisdomValueLabel, characterSheetCharismaValueLabel);
        characterSheetAbilitiesValuesVBox.setAlignment(Pos.CENTER);
        characterSheetStrengthModifierVBox.getStyleClass().add("cs-label");
        characterSheetDexterityModifierVBox.getStyleClass().add("cs-label");
        characterSheetConsitutionModifierVBox.getStyleClass().add("cs-label");
        characterSheetIntelligenceModifierVBox.getStyleClass().add("cs-label");
        characterSheetWisdomModifierVBox.getStyleClass().add("cs-label");
        characterSheetCharismaModifierVBox.getStyleClass().add("cs-label");
        VBox characterSheetAbilityModifierVBox = new VBox(characterSheetStrengthModifierVBox, characterSheetDexterityModifierVBox, characterSheetConsitutionModifierVBox, characterSheetIntelligenceModifierVBox, characterSheetWisdomModifierVBox, characterSheetCharismaModifierVBox);
        characterSheetAbilityModifierVBox.setAlignment(Pos.CENTER);
        HBox characterSheetAbilitiesHBox = new HBox(characterSheetAbilitiesListVBox, characterSheetAbilityModifierVBox, characterSheetAbilitiesValuesVBox);
        characterSheetAbilitiesHBox.setSpacing(40);
        characterSheetAbilitiesHBox.setAlignment(Pos.CENTER);
        VBox characterSheetAbilitiesVBox = new VBox(characterSheetAbilitiesLabel, characterSheetAbilitiesHBox);
        characterSheetAbilitiesVBox.setAlignment(Pos.CENTER);

        Label characterSheetProficienciesLabel = new Label("Proficiencies");
        characterSheetProficienciesLabel.getStyleClass().add("cs-header-label");
        Label characterSheetArmourProficienciesListLabel = new Label("Armour");
        characterSheetArmourProficienciesListLabel.getStyleClass().add("cs-label");
        Label characterSheetSimpleWeaponsProficienciesListLabel = new Label("Simple Weapons");
        characterSheetSimpleWeaponsProficienciesListLabel.getStyleClass().add("cs-label");
        Label characterSheetMartialWeaponsProficienciesListLabel = new Label("Martial Weapons");
        characterSheetMartialWeaponsProficienciesListLabel.getStyleClass().add("cs-label");
        VBox characterSheetProficienciesListVBox = new VBox(characterSheetArmourProficienciesListLabel, characterSheetSimpleWeaponsProficienciesListLabel, characterSheetMartialWeaponsProficienciesListLabel);
        characterSheetProficienciesListVBox.setAlignment(Pos.TOP_LEFT);
        characterSheetArmourProficienciesValuesLabel.getStyleClass().add("cs-label");
        characterSheetSimpleWeaponsProficienciesValuesLabel.getStyleClass().add("cs-label");
        characterSheetMartialWeaponsProficienciesValuesLabel.getStyleClass().add("cs-label");
        VBox characterSheetProficienciesValuesVBox = new VBox(characterSheetArmourProficienciesValuesLabel, characterSheetSimpleWeaponsProficienciesValuesLabel, characterSheetMartialWeaponsProficienciesValuesLabel);
        characterSheetProficienciesValuesVBox.setAlignment(Pos.CENTER);
        HBox characterSheetProficienciesHBox = new HBox(characterSheetProficienciesListVBox, characterSheetProficienciesValuesVBox);
        characterSheetProficienciesHBox.setSpacing(70);
        characterSheetProficienciesHBox.setAlignment(Pos.CENTER);
        VBox characterSheetProficienciesVBox = new VBox(characterSheetProficienciesLabel, characterSheetProficienciesHBox);
        characterSheetProficienciesVBox.setAlignment(Pos.CENTER);

        VBox characterSheetColumn2VBox = new VBox(characterSheetStatsVBox, characterSheetAbilitiesVBox, characterSheetProficienciesVBox);
        characterSheetColumn2VBox.setAlignment(Pos.CENTER);
        characterSheetColumn2VBox.setSpacing(20);

        Label characterSheetSkillsLabel = new Label("Skills");
        characterSheetSkillsLabel.getStyleClass().add("cs-header-label");
        Label characterSheetAcrobaticsListLabel = new Label("Acrobatics");
        characterSheetAcrobaticsListLabel.getStyleClass().add("cs-label");
        Label characterSheetAnimalHandlingListLabel = new Label("Animal Handling");
        characterSheetAnimalHandlingListLabel.getStyleClass().add("cs-label");
        Label characterSheetArcanaListLabel = new Label("Arcana");
        characterSheetArcanaListLabel.getStyleClass().add("cs-label");
        Label characterSheetAthleticsListLabel = new Label("Athletics");
        characterSheetAthleticsListLabel.getStyleClass().add("cs-label");
        Label characterSheetDeceptionListLabel = new Label("Deception");
        characterSheetDeceptionListLabel.getStyleClass().add("cs-label");
        Label characterSheetHistoryListLabel = new Label("History");
        characterSheetHistoryListLabel.getStyleClass().add("cs-label");
        Label characterSheetInsightListLabel = new Label("Insight");
        characterSheetInsightListLabel.getStyleClass().add("cs-label");
        Label characterSheetIntimidationListLabel = new Label("Intimidation");
        characterSheetIntimidationListLabel.getStyleClass().add("cs-label");
        Label characterSheetInvestigationListLabel = new Label("Investigation");
        characterSheetInvestigationListLabel.getStyleClass().add("cs-label");
        Label characterSheetMedicineListLabel = new Label("Medicine");
        characterSheetMedicineListLabel.getStyleClass().add("cs-label");
        Label characterSheetNatureListLabel = new Label("Nature");
        characterSheetNatureListLabel.getStyleClass().add("cs-label");
        Label characterSheetPerceptionListLabel = new Label("Perception");
        characterSheetPerceptionListLabel.getStyleClass().add("cs-label");
        Label characterSheetPerformanceListLabel = new Label("Performance");
        characterSheetPerformanceListLabel.getStyleClass().add("cs-label");
        Label characterSheetPersuasionListLabel = new Label("Persuasion");
        characterSheetPersuasionListLabel.getStyleClass().add("cs-label");
        Label characterSheetReligionListLabel = new Label("Religion");
        characterSheetReligionListLabel.getStyleClass().add("cs-label");
        Label characterSheetSleightOfHandListLabel = new Label("Sleight of Hand");
        characterSheetSleightOfHandListLabel.getStyleClass().add("cs-label");
        Label characterSheetStealthListLabel = new Label("Stealth");
        characterSheetStealthListLabel.getStyleClass().add("cs-label");
        Label characterSheetSurvivalListLabel = new Label("Survival");
        characterSheetSurvivalListLabel.getStyleClass().add("cs-label");
        VBox characterSheetSkillsListVBox = new VBox(characterSheetAcrobaticsListLabel, characterSheetAnimalHandlingListLabel, characterSheetArcanaListLabel, characterSheetAthleticsListLabel, characterSheetDeceptionListLabel, characterSheetHistoryListLabel, characterSheetInsightListLabel, characterSheetIntimidationListLabel, characterSheetInvestigationListLabel, characterSheetMedicineListLabel, characterSheetNatureListLabel, characterSheetPerceptionListLabel, characterSheetPerformanceListLabel, characterSheetPersuasionListLabel, characterSheetReligionListLabel, characterSheetSleightOfHandListLabel, characterSheetStealthListLabel, characterSheetSurvivalListLabel);
        characterSheetSkillsListVBox.setAlignment(Pos.TOP_LEFT);
        characterSheetAcrobaticsValueLabel.getStyleClass().add("cs-label");
        characterSheetAnimalHandlingValueLabel.getStyleClass().add("cs-label");
        characterSheetArcanaValueLabel.getStyleClass().add("cs-label");
        characterSheetAthleticsValueLabel.getStyleClass().add("cs-label");
        characterSheetDeceptionValueLabel.getStyleClass().add("cs-label");
        characterSheetHistoryValueLabel.getStyleClass().add("cs-label");
        characterSheetInsightValueLabel.getStyleClass().add("cs-label");
        characterSheetIntimidationValueLabel.getStyleClass().add("cs-label");
        characterSheetInvestigationValueLabel.getStyleClass().add("cs-label");
        characterSheetMedicineValueLabel.getStyleClass().add("cs-label");
        characterSheetNatureValueLabel.getStyleClass().add("cs-label");
        characterSheetPerceptionValueLabel.getStyleClass().add("cs-label");
        characterSheetPerformanceValueLabel.getStyleClass().add("cs-label");
        characterSheetPersuasionValueLabel.getStyleClass().add("cs-label");
        characterSheetReligionValueLabel.getStyleClass().add("cs-label");
        characterSheetSleightOfHandValueLabel.getStyleClass().add("cs-label");
        characterSheetStealthValueLabel.getStyleClass().add("cs-label");
        characterSheetSurvivalValueLabel.getStyleClass().add("cs-label");
        VBox characterSheetSkillsValuesVBox = new VBox(characterSheetAcrobaticsValueLabel, characterSheetAnimalHandlingValueLabel, characterSheetArcanaValueLabel, characterSheetAthleticsValueLabel, characterSheetDeceptionValueLabel, characterSheetHistoryValueLabel, characterSheetInsightValueLabel, characterSheetIntimidationValueLabel, characterSheetInvestigationValueLabel, characterSheetMedicineValueLabel, characterSheetNatureValueLabel, characterSheetPerceptionValueLabel, characterSheetPerformanceValueLabel, characterSheetPersuasionValueLabel, characterSheetReligionValueLabel, characterSheetSleightOfHandValueLabel, characterSheetStealthValueLabel, characterSheetSurvivalValueLabel);
        characterSheetSkillsValuesVBox.setAlignment(Pos.TOP_RIGHT);
        HBox characterSheetSkillsHBox = new HBox(characterSheetSkillsListVBox, characterSheetSkillsValuesVBox);
        characterSheetSkillsHBox.setSpacing(50);
        characterSheetSkillsHBox.setAlignment(Pos.CENTER);
        VBox characterSheetSkillsVBox = new VBox(characterSheetSkillsLabel, characterSheetSkillsHBox);
        characterSheetSkillsVBox.setAlignment(Pos.CENTER);

        VBox characterSheetColumn3VBox = new VBox(characterSheetSkillsVBox);
        characterSheetColumn3VBox.setAlignment(Pos.CENTER);

        HBox characterSheetHBox = new HBox(characterSheetColumn1VBox, characterSheetColumn2VBox, characterSheetColumn3VBox);
        characterSheetHBox.setAlignment(Pos.CENTER);
        characterSheetHBox.setSpacing(70);
        MenuButton characterSheetPDFButton = new MenuButton("Create PDF");
        MenuButton characterSheetBackButton = new MenuButton("Back");
        HBox characterSheetButtonHBox = new HBox(characterSheetPDFButton, characterSheetBackButton);
        characterSheetButtonHBox.setAlignment(Pos.CENTER);
        characterSheetButtonHBox.setSpacing(10);
        VBox characterSheetVBox = new VBox(characterSheetHBox, characterSheetButtonHBox);
        characterSheetVBox.setSpacing(30);
        characterSheetVBox.setAlignment(Pos.CENTER);
        characterSheetVBox.setTranslateY(20);
        Group characterSheetGroup = new Group(characterSheetVBox);
        StackPane characterSheetStackPane = new StackPane(characterSheetBorderImageView, characterSheetGroup);
        Group characterSheetMainGroup = new Group(characterSheetStackPane);

        Scene scene = new Scene(new StackPane(backgroundImageView, characterBuilderStackPane), 1500, 843.75);
        scene.getStylesheets().add(getClass().getResource("/com/advantageplay/bg3characterbuilder/Stylesheet.css").toString());
        stage.setTitle("Baldur's Gate 3 Character Builder");
        stage.getIcons().add(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/BG3CharacterBuilderIcon.png").toString()));
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

        cantripsButton.getButton().setOnAction(event -> characterBuilderStackPane.getChildren().add(cantripsStackPane));
        cantripsConfirmButton.getButton().setOnAction(event -> characterBuilderStackPane.getChildren().remove(cantripsStackPane));

        spellsButton.getButton().setOnAction(event -> characterBuilderStackPane.getChildren().add(spellsStackPane));
        spellsConfirmButton.getButton().setOnAction(event -> characterBuilderStackPane.getChildren().remove(spellsStackPane));

        skillsButton.getButton().setOnAction(event -> characterBuilderStackPane.getChildren().add(skillsStackPane));
        skillsConfirmButton.getButton().setOnAction(event -> characterBuilderStackPane.getChildren().remove(skillsStackPane));

        viewBackstoryButton.getButton().setOnAction(event -> characterBuilderStackPane.getChildren().add(backstoryPanelStackPane));
        backstoryPanelButton.getButton().setOnAction(event -> characterBuilderStackPane.getChildren().remove(backstoryPanelStackPane));

        characterSheetButton.getButton().setOnAction(event -> {
            generateCharacterSheet();
            characterBuilderStackPane.getChildren().add(characterSheetMainGroup);
        });
        characterSheetBackButton.getButton().setOnAction(event -> characterBuilderStackPane.getChildren().remove(characterSheetMainGroup));
        characterSheetPDFButton.getButton().setOnAction(event -> {
            PrinterJob job = PrinterJob.createPrinterJob();
            PageLayout pageLayout = job.getPrinter().createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
            job.getJobSettings().setPageLayout(pageLayout);
            characterSheetButtonHBox.setVisible(false);
            characterSheetMainGroup.setScaleX(0.77);
            characterSheetMainGroup.setScaleY(0.8);
            characterSheetMainGroup.setTranslateX(-328);
            characterSheetMainGroup.setTranslateY(-125);
            if(job != null) {
                job.showPrintDialog(stage); // Window must be your main Stage
                job.printPage(characterSheetMainGroup);
                job.endJob();
                characterSheetMainGroup.setTranslateX(0);
                characterSheetMainGroup.setTranslateY(0);
                characterSheetMainGroup.setScaleX(1);
                characterSheetMainGroup.setScaleY(1);
                characterSheetButtonHBox.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {launch();}

    public static String chatGPT(String prompt) {
        String apiKey = "sk-Ns1ct4G7hltIottktSSDT3BlbkFJfr5ZdICnolKePHRiExG";
        String url = "https://api.openai.com/v1/chat/completions";
        String model = "gpt-3.5-turbo";

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();
            return extractMessageFromJSONResponse(response.toString());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String extractMessageFromJSONResponse(String response) {
        int start = response.indexOf("content") + 11;
        int end = response.indexOf("\"", start);
        return response.substring(start, end);
    }

    private void generateCharacterSheet() {
        characterSheetNameValueLabel.setText(nameTextField.getText());
        if (!subrace.isEmpty()) characterSheetRaceValueLabel.setText(subrace);
        else characterSheetRaceValueLabel.setText(race);
        characterSheetClassValueLabel.setText(subclass + " " + playerClass);
        characterSheetBackgroundValueLabel.setText(background);
        characterSheetAlignmentValueLabel.setText(lawfulChaoticString + " " + goodEvilString);

        characterSheetBackstoryParagraph.clear();
        characterSheetBackstoryLabelList.clear();
        characterSheetBackstoryParagraphVBox.getChildren().clear();
        characterSheetBackstoryString = backstoryString;
        tempString = "";
        for (int i = 0; i < characterSheetBackstoryString.length(); i++) {
            tempString = tempString + characterSheetBackstoryString.charAt(i);
            if (tempString.length() >= 55 && characterSheetBackstoryString.charAt(i) == ' ') {
                characterSheetBackstoryParagraph.add(tempString);
                tempString = "";
            }
        }
        characterSheetBackstoryParagraph.add(tempString);
        for (int i = 0; i < characterSheetBackstoryParagraph.size(); i++) {
            characterSheetBackstoryLabelList.add(new Label(characterSheetBackstoryParagraph.get(i)));
            characterSheetBackstoryLabelList.get(i).getStyleClass().add("cs-label");
            characterSheetBackstoryLabelList.get(i).setAlignment(Pos.CENTER);
        }
        tempString = "";
        tempInt = 0;
        for (int i = 0; i < characterSheetBackstoryParagraph.size(); i++) characterSheetBackstoryParagraphVBox.getChildren().add(characterSheetBackstoryLabelList.get(i));
        characterSheetBackstoryParagraphVBox.setAlignment(Pos.CENTER);
        switch (playerClass) {
            case "Barbarian":
                characterSheetHPValueLabel.setText(Integer.toString(12 + constitutionHBox.getModifier()));
                break;
            case "Fighter", "Paladin", "Ranger":
                characterSheetHPValueLabel.setText(Integer.toString(10 + constitutionHBox.getModifier()));
                break;
            case "Bard", "Cleric", "Druid", "Monk", "Rogue", "Warlock":
                characterSheetHPValueLabel.setText(Integer.toString(8 + constitutionHBox.getModifier()));
                break;
            case "Sorcerer", "Wizard":
                characterSheetHPValueLabel.setText(Integer.toString(6 + constitutionHBox.getModifier()));
                break;
        }
        characterSheetACValueLabel.setText(Integer.toString(10 + dexterityHBox.getModifier()));
        switch (race) {
            case "Dwarf", "Gnome", "Halfling":
                characterSheetSpeedValueLabel.setText("7.5m / 25ft");
                break;
            default:
                characterSheetSpeedValueLabel.setText("9.0m / 30ft");
                break;
        }
        characterSheetInitiativeValueLabel.setText(Integer.toString(dexterityHBox.getModifier()));
        if (race.equals("Human")) characterSheetCarryValueLabel.setText(Double.toString(1.25 * (40 + (10 * strengthHBox.getAdjustedValue()))) + "kg / " + Double.toString(1.25 * (2 * ( 40 + (10 * strengthHBox.getAdjustedValue())))) + "lbs");
        else characterSheetCarryValueLabel.setText(Double.toString(40 + (10 * strengthHBox.getAdjustedValue())) + "kg / " + Double.toString(2 * ( 40 + (10 * strengthHBox.getAdjustedValue()))) + "lbs");
        characterSheetStrengthValueLabel.setText(Integer.toString( + strengthHBox.getAdjustedValue()));
        characterSheetDexterityValueLabel.setText(Integer.toString(dexterityHBox.getAdjustedValue()));
        characterSheetConstitutionValueLabel.setText(Integer.toString(constitutionHBox.getAdjustedValue()));
        characterSheetIntelligenceValueLabel.setText(Integer.toString(intelligenceHBox.getAdjustedValue()));
        characterSheetWisdomValueLabel.setText(Integer.toString(wisdomHBox.getAdjustedValue()));
        characterSheetCharismaValueLabel.setText(Integer.toString(charismaHBox.getAdjustedValue()));
        if (strengthHBox.getModifier() >= 0) characterSheetStrengthModifierVBox.setText("+" + Integer.toString(strengthHBox.getModifier()));
        else characterSheetStrengthModifierVBox.setText(Integer.toString(strengthHBox.getModifier()));
        if (dexterityHBox.getModifier() >= 0) characterSheetDexterityModifierVBox.setText("+" + Integer.toString(dexterityHBox.getModifier()));
        else characterSheetDexterityModifierVBox.setText(Integer.toString(dexterityHBox.getModifier()));
        if (constitutionHBox.getModifier() >= 0) characterSheetConsitutionModifierVBox.setText("+" + Integer.toString(constitutionHBox.getModifier()));
        else characterSheetConsitutionModifierVBox.setText(Integer.toString(constitutionHBox.getModifier()));
        if (intelligenceHBox.getModifier() >= 0) characterSheetIntelligenceModifierVBox.setText("+" + Integer.toString(intelligenceHBox.getModifier()));
        else characterSheetIntelligenceModifierVBox.setText(Integer.toString(intelligenceHBox.getModifier()));
        if (wisdomHBox.getModifier() >= 0) characterSheetWisdomModifierVBox.setText("+" + Integer.toString(wisdomHBox.getModifier()));
        else characterSheetWisdomModifierVBox.setText(Integer.toString(wisdomHBox.getModifier()));
        if (charismaHBox.getModifier() >= 0) characterSheetCharismaModifierVBox.setText("+" + Integer.toString(charismaHBox.getModifier()));
        else characterSheetCharismaModifierVBox.setText(Integer.toString(charismaHBox.getModifier()));
        if (playerClass.equals("Fighter") || playerClass.equals("Paladin")) characterSheetArmourProficienciesValuesLabel.setText("x4");
        else if (playerClass.equals("Barbarian") || playerClass.equals("Cleric") || playerClass.equals("Druid") || playerClass.equals("Ranger")) characterSheetArmourProficienciesValuesLabel.setText("x3");
        else if (playerClass.equals("Bard") || playerClass.equals("Rogue") || playerClass.equals("Warlock")) {
            if (race.equals("Githyanki") || race.equals("Half-Elf") || race.equals("Human"))characterSheetArmourProficienciesValuesLabel.setText("x2");
            else characterSheetArmourProficienciesValuesLabel.setText("x1");
        }
        else if (playerClass.equals("Sorcerer") || playerClass.equals("Wizard")) {
            if (race.equals("Githyanki") || race.equals("Half-Elf") || race.equals("Human")) characterSheetArmourProficienciesValuesLabel.setText("x2");
            else characterSheetArmourProficienciesValuesLabel.setText("x0");
        }
        if (playerClass.equals("Bard") || playerClass.equals("Cleric") || playerClass.equals("Fighter") || playerClass.equals("Ranger") || playerClass.equals("Rogue") || playerClass.equals("Warlock") || playerClass.equals("Paladin")) characterSheetSimpleWeaponsProficienciesValuesLabel.setText("x12");
        else if (playerClass.equals("Druid")) {
            if (race.equals("Dwarf")) characterSheetSimpleWeaponsProficienciesValuesLabel.setText("x9");
            else if (race.equals("Elf")) characterSheetSimpleWeaponsProficienciesValuesLabel.setText("x8");
            else characterSheetSimpleWeaponsProficienciesValuesLabel.setText("x7");
        }
        else if (playerClass.equals("Sorcerer")|| playerClass.equals("Wizard")) {
            if (race.equals("Dwarf")) characterSheetSimpleWeaponsProficienciesValuesLabel.setText("x5");
            else if (race.equals("Elf")) characterSheetSimpleWeaponsProficienciesValuesLabel.setText("x4");
            else characterSheetSimpleWeaponsProficienciesValuesLabel.setText("x3");
        }
        if (playerClass.equals("Barbarian") || playerClass.equals("Fighter") || playerClass.equals("Paladin")) characterSheetMartialWeaponsProficienciesValuesLabel.setText("x19");
        else if (playerClass.equals("Bard") || playerClass.equals("Rogue")) {
            if (race.equals("Dwarf")) characterSheetMartialWeaponsProficienciesValuesLabel.setText("x6");
            else if (race.equals("Elf") || playerClass.equals("Githyanki")) characterSheetMartialWeaponsProficienciesValuesLabel.setText("5");
            else characterSheetMartialWeaponsProficienciesValuesLabel.setText("x4");
        }
        else if (playerClass.equals("Cleric")) {
            if (race.equals("Drow") || race.equals("Elf") || race.equals("Githyanki")) characterSheetMartialWeaponsProficienciesValuesLabel.setText("x5");
            else if (race.equals("Dwarf")) characterSheetMartialWeaponsProficienciesValuesLabel.setText("x4");
            else characterSheetMartialWeaponsProficienciesValuesLabel.setText("x2");
        }
        else if (playerClass.equals("Druid")) {
            if (race.equals("Drow") || race.equals("Elf") || race.equals("Githyanki")) characterSheetMartialWeaponsProficienciesValuesLabel.setText("x4");
            else if (race.equals("Dwarf")) characterSheetMartialWeaponsProficienciesValuesLabel.setText("x3");
            else characterSheetMartialWeaponsProficienciesValuesLabel.setText("x1");
        }
        else if (playerClass.equals("Sorcerer") || playerClass.equals("Warlock") || playerClass.equals("Wizard")) {
            if (race.equals("Drow") || race.equals("Elf") || race.equals("Githyanki")) characterSheetMartialWeaponsProficienciesValuesLabel.setText("x3");
            else if (race.equals("Dwarf")) characterSheetMartialWeaponsProficienciesValuesLabel.setText("x2");
            else characterSheetMartialWeaponsProficienciesValuesLabel.setText("x0");
        }
        characterSheetAcrobaticsValueLabel.setText(acrobaticsHBox.getModifierLabel().getText());
        characterSheetAcrobaticsValueLabel.setText(acrobaticsHBox.getModifierLabel().getText());
        characterSheetAnimalHandlingValueLabel.setText(animalHandlingHBox.getModifierLabel().getText());
        characterSheetArcanaValueLabel.setText(arcanaHBox.getModifierLabel().getText());
        characterSheetAthleticsValueLabel.setText(athleticsHBox.getModifierLabel().getText());
        characterSheetDeceptionValueLabel.setText(deceptionHBox.getModifierLabel().getText());
        characterSheetHistoryValueLabel.setText(historyHBox.getModifierLabel().getText());
        characterSheetInsightValueLabel.setText(insightHBox.getModifierLabel().getText());
        characterSheetIntimidationValueLabel.setText(intimidationHBox.getModifierLabel().getText());
        characterSheetInvestigationValueLabel.setText(intimidationHBox.getModifierLabel().getText());
        characterSheetMedicineValueLabel.setText(intimidationHBox.getModifierLabel().getText());
        characterSheetNatureValueLabel.setText(natureHBox.getModifierLabel().getText());
        characterSheetPerceptionValueLabel.setText(perceptionHBox.getModifierLabel().getText());
        characterSheetPerformanceValueLabel.setText(performanceHBox.getModifierLabel().getText());
        characterSheetPersuasionValueLabel.setText(persuasionHBox.getModifierLabel().getText());
        characterSheetReligionValueLabel.setText(religionHBox.getModifierLabel().getText());
        characterSheetSleightOfHandValueLabel.setText(sleightOfHandHBox.getModifierLabel().getText());
        characterSheetStealthValueLabel.setText(stealthHBox.getModifierLabel().getText());
        characterSheetSurvivalValueLabel.setText(survivalHBox.getModifierLabel().getText());
    }

    private void generateRandomName() {
        int temp = random.nextInt(20);
        if (Objects.equals(gender, "Female")) {
            switch (temp) {
                case 0: playerName = "Cateline";
                break;
                case 1: playerName = "Seraphine";
                break;
                case 2: playerName = "Desarae";
                break;
                case 3: playerName = "Cherise";
                break;
                case 4: playerName = "Uta";
                break;
                case 5: playerName = "Nafia";
                break;
                case 6: playerName = "Agathe";
                break;
                case 7: playerName = "Sarai";
                break;
                case 8: playerName = "Aislinn";
                break;
                case 9: playerName = "Adalie";
                break;
                case 10: playerName = "Corliss";
                break;
                case 11: playerName = "Mai";
                break;
                case 12: playerName = "Calantha";
                break;
                case 13: playerName = "Lyndsey";
                break;
                case 14: playerName = "Eldrina";
                break;
                case 15: playerName = "Elisabeth";
                break;
                case 16: playerName = "Joli";
                break;
                case 17: playerName = "Lacee";
                break;
                case 18: playerName = "Valeria";
                break;
                case 19: playerName = "Charlotta";
                break;
            }
        }
        else if (Objects.equals(gender, "Male")){
            switch (temp) {
                case 0: playerName = "Adison";
                break;
                case 1: playerName = "Linn";
                break;
                case 2: playerName = "Zadoc";
                break;
                case 3: playerName = "Brennen";
                break;
                case 4: playerName = "Rylan";
                break;
                case 5: playerName = "Kourosh";
                break;
                case 6: playerName = "Egerton";
                break;
                case 7: playerName = "Corben";
                break;
                case 8: playerName = "Gregor";
                break;
                case 9: playerName = "Bosse";
                break;
                case 10: playerName = "Egbert";
                break;
                case 11: playerName = "Florin";
                break;
                case 12: playerName = "Cortland";
                break;
                case 13: playerName = "Alton";
                break;
                case 14: playerName = "Kallistus";
                break;
                case 15: playerName = "Terenz";
                break;
                case 16: playerName = "Baruch";
                break;
                case 17: playerName = "Thibaut";
                break;
                case 18: playerName = "Garvin";
                break;
                case 19: playerName = "Taavi";
                break;
            }
        }
        else {
            switch (temp) {
                case 0: playerName = "Adison";
                    break;
                case 1: playerName = "Linn";
                    break;
                case 2: playerName = "Zadoc";
                    break;
                case 3: playerName = "Brennen";
                    break;
                case 4: playerName = "Rylan";
                    break;
                case 5: playerName = "Kourosh";
                    break;
                case 6: playerName = "Egerton";
                    break;
                case 7: playerName = "Corben";
                    break;
                case 8: playerName = "Gregor";
                    break;
                case 9: playerName = "Bosse";
                    break;
                case 10: playerName = "Egbert";
                    break;
                case 11: playerName = "Florin";
                    break;
                case 12: playerName = "Cortland";
                    break;
                case 13: playerName = "Alton";
                    break;
                case 14: playerName = "Kallistus";
                    break;
                case 15: playerName = "Terenz";
                    break;
                case 16: playerName = "Baruch";
                    break;
                case 17: playerName = "Thibaut";
                    break;
                case 18: playerName = "Garvin";
                    break;
                case 19: playerName = "Taavi";
                    break;
            }
        }

        nameTextField.setText(playerName);
    }

    private void selectClassCantrip(SpellButton classCantripButton, SpellButton raceCantripButton) {
        classCantripButton.setSelected();

        if (classCantripButton.isSelected()) {
            if (remainingClassCantrips > 0) {
                if (subrace.equals("Asmodeus Tiefling") && classCantripButton == produceFlameClassButton) classCantripButton.setSelected();
                else if (subrace.equals("Mephistopheles Tiefling") && classCantripButton == mageHandClassButton) classCantripButton.setSelected();
                else if (subrace.equals("Zariel Tiefling") && classCantripButton == thaumaturgyClassButton) classCantripButton.setSelected();
                else if ((subrace.equals("Lolth-Sworn Drow") || subrace.equals("Seldarine Drow") || subrace.equals("Drow Half-Elf")) && classCantripButton == dancingLightsClassButton) classCantripButton.setSelected();
                else {
                    remainingClassCantrips--;
                    classCantripPointsLabel.setText("(" + remainingClassCantrips + "/" + totalClassCantrips + ")");
                    if (raceCantripButton != null) {
                        if (raceCantripButton.isSelected()) {
                            raceCantripButton.setSelected();
                            remainingRaceCantrips++;
                            raceCantripPointsLabel.setText("(" + remainingRaceCantrips + "/" + totalRaceCantrips + ")");
                        }
                    }
                }
            }
            else classCantripButton.setSelected();
        }
        else {
            remainingClassCantrips++;
            classCantripPointsLabel.setText("(" + remainingClassCantrips + "/" + totalClassCantrips + ")");
        }
    }

    private void selectOneBonusCheckBox(AbilityHBox abilityHBox) {
        if (isOneBonusSelected) {
            if (!abilityHBox.getOneBonusCheckBox().isSelected()){
                abilityHBox.setAdjustedValue(0);
                isOneBonusSelected = false;
            }
            else {
                abilityHBox.setAdjustedValue(1);
                isOneBonusSelected = true;
            }
            if (abilityHBox != strengthHBox && strengthHBox.getOneBonusCheckBox().isSelected()) {
                strengthHBox.getOneBonusCheckBox().setSelected(false);
                strengthHBox.setAdjustedValue(0);
            }
            if (abilityHBox != dexterityHBox && dexterityHBox.getOneBonusCheckBox().isSelected()) {
                dexterityHBox.getOneBonusCheckBox().setSelected(false);
                dexterityHBox.setAdjustedValue(0);
            }
            if (abilityHBox != constitutionHBox && constitutionHBox.getOneBonusCheckBox().isSelected()) {
                constitutionHBox.getOneBonusCheckBox().setSelected(false);
                constitutionHBox.setAdjustedValue(0);
            }
            if (abilityHBox != intelligenceHBox && intelligenceHBox.getOneBonusCheckBox().isSelected()) {
                intelligenceHBox.getOneBonusCheckBox().setSelected(false);
                intelligenceHBox.setAdjustedValue(0);
            }
            if (abilityHBox != wisdomHBox && wisdomHBox.getOneBonusCheckBox().isSelected()) {
                wisdomHBox.getOneBonusCheckBox().setSelected(false);
                wisdomHBox.setAdjustedValue(0);
            }
            if (abilityHBox != charismaHBox && charismaHBox.getOneBonusCheckBox().isSelected()) {
                charismaHBox.getOneBonusCheckBox().setSelected(false);
                charismaHBox.setAdjustedValue(0);
            }
        }
        else {
            if (abilityHBox.getTwoBonusCheckBox().isSelected()) {
                abilityHBox.getTwoBonusCheckBox().setSelected(false);
                isTwoBonusSelected = false;
            }
            abilityHBox.setAdjustedValue(1);
            isOneBonusSelected = true;
        }
        resetSkills();
    }

    private void selectRaceCantrip(SpellButton raceCantripButton, SpellButton classCantripButton) {
        raceCantripButton.setSelected();

        if (raceCantripButton.isSelected()) {
            if (remainingRaceCantrips > 0) {
                remainingRaceCantrips--;
                raceCantripPointsLabel.setText("(" + remainingRaceCantrips + "/" + totalRaceCantrips + ")");
                if (classCantripButton.isSelected()) {
                    classCantripButton.setSelected();
                    remainingClassCantrips++;
                    classCantripPointsLabel.setText("(" + remainingClassCantrips + "/" + totalClassCantrips + ")");
                }
            }
            else raceCantripButton.setSelected();
        }
        else {
            remainingRaceCantrips++;
            raceCantripPointsLabel.setText("(" + remainingRaceCantrips + "/" + totalRaceCantrips + ")");
        }
    }

    private void selectSkill(SkillHBox skillHBox) {
        if (skillHBox.getSkillCheckBox().isSelected()) {
            if (remainingSkillPoints > 0) {
                skillHBox.getSkillCheckBox().setSelected(true);
                skillHBox.setSelectBonus(2);
                if (skillHBox.getAbility().getModifier() + skillHBox.getRaceBonus() + skillHBox.getBackgroundBonus() + skillHBox.getSelectBonus() >= 0) skillHBox.getModifierLabel().setText("+" + Integer.toString(skillHBox.getAbility().getModifier() + skillHBox.getRaceBonus() + skillHBox.getBackgroundBonus() + skillHBox.getSelectBonus()));
                else skillHBox.getModifierLabel().setText(Integer.toString(skillHBox.getAbility().getModifier() + skillHBox.getRaceBonus() + skillHBox.getBackgroundBonus() + skillHBox.getSelectBonus()));
                remainingSkillPoints--;
            }
        }
        else {
            skillHBox.getSkillCheckBox().setSelected(false);
            skillHBox.setSelectBonus(0);
            if (skillHBox.getAbility().getModifier() + skillHBox.getRaceBonus() + skillHBox.getBackgroundBonus() + skillHBox.getSelectBonus() >= 0) skillHBox.getModifierLabel().setText("+" + Integer.toString(skillHBox.getAbility().getModifier() + skillHBox.getRaceBonus() + skillHBox.getBackgroundBonus() + skillHBox.getSelectBonus()));
            else skillHBox.getModifierLabel().setText(Integer.toString(skillHBox.getAbility().getModifier() + skillHBox.getRaceBonus() + skillHBox.getBackgroundBonus() + skillHBox.getSelectBonus()));
            remainingSkillPoints++;
        }
        skillPointsLabel.setText("(" + remainingSkillPoints + "/" + totalSkillPoints + ")");
    }

    private void selectSpell(SpellButton spellButton) {
        spellButton.setSelected();

        if (spellButton.isSelected()) {
            if (remainingSpellPoints > 0) {
                remainingSpellPoints--;
                spellsPointsLabel.setText("(" + remainingSpellPoints + "/" + totalSpellPoints + ")");
            }
            else spellButton.setSelected();
        }
        else {
            remainingSpellPoints++;
            spellsPointsLabel.setText("(" + remainingSpellPoints + "/" + totalSpellPoints + ")");
        }
    }

    private void selectTwoBonusCheckBox(AbilityHBox abilityHBox) {
        if (isTwoBonusSelected) {
            if (!abilityHBox.getTwoBonusCheckBox().isSelected()){
                abilityHBox.setAdjustedValue(0);
                isTwoBonusSelected = false;
            }
            else {
                abilityHBox.setAdjustedValue(2);
                isTwoBonusSelected = true;
            }
            if (abilityHBox != strengthHBox && strengthHBox.getTwoBonusCheckBox().isSelected()) {
                strengthHBox.getTwoBonusCheckBox().setSelected(false);
                strengthHBox.setAdjustedValue(0);
            }
            if (abilityHBox != dexterityHBox && dexterityHBox.getTwoBonusCheckBox().isSelected()) {
                dexterityHBox.getTwoBonusCheckBox().setSelected(false);
                dexterityHBox.setAdjustedValue(0);
            }
            if (abilityHBox != constitutionHBox && constitutionHBox.getTwoBonusCheckBox().isSelected()) {
                constitutionHBox.getTwoBonusCheckBox().setSelected(false);
                constitutionHBox.setAdjustedValue(0);
            }
            if (abilityHBox != intelligenceHBox && intelligenceHBox.getTwoBonusCheckBox().isSelected()) {
                intelligenceHBox.getTwoBonusCheckBox().setSelected(false);
                intelligenceHBox.setAdjustedValue(0);
            }
            if (abilityHBox != wisdomHBox && wisdomHBox.getTwoBonusCheckBox().isSelected()) {
                wisdomHBox.getTwoBonusCheckBox().setSelected(false);
                wisdomHBox.setAdjustedValue(0);
            }
            if (abilityHBox != charismaHBox && charismaHBox.getTwoBonusCheckBox().isSelected()) {
                charismaHBox.getTwoBonusCheckBox().setSelected(false);
                charismaHBox.setAdjustedValue(0);
            }
        }
        else {
            if (abilityHBox.getOneBonusCheckBox().isSelected()) {
                abilityHBox.getOneBonusCheckBox().setSelected(false);
                isOneBonusSelected = false;
            }
            abilityHBox.setAdjustedValue(2);
            isTwoBonusSelected = true;
        }
        resetSkills();
    }

    private void setBackground(String background) {
        switch (this.background) {
            case "Acolyte":
                insightHBox.setBackgroundBonus(0);
                insightHBox.getSkillCheckBox().setVisible(true);
                religionHBox.setBackgroundBonus(0);
                religionHBox.getSkillCheckBox().setVisible(true);
                break;
            case "Charlatan":
                deceptionHBox.setBackgroundBonus(0);
                deceptionHBox.getSkillCheckBox().setVisible(true);
                sleightOfHandHBox.setBackgroundBonus(0);
                sleightOfHandHBox.getSkillCheckBox().setVisible(true);
                break;
            case "Criminal":
                deceptionHBox.setBackgroundBonus(0);
                deceptionHBox.getSkillCheckBox().setVisible(true);
                stealthHBox.setBackgroundBonus(0);
                stealthHBox.getSkillCheckBox().setVisible(true);
                break;
            case "Entertainer":
                acrobaticsHBox.setBackgroundBonus(0);
                acrobaticsHBox.getSkillCheckBox().setVisible(true);
                performanceHBox.setBackgroundBonus(0);
                performanceHBox.getSkillCheckBox().setVisible(true);
                break;
            case "Folk Hero":
                animalHandlingHBox.setBackgroundBonus(0);
                animalHandlingHBox.getSkillCheckBox().setVisible(true);
                survivalHBox.setBackgroundBonus(0);
                survivalHBox.getSkillCheckBox().setVisible(true);
                break;
            case "Guild Artisan":
                insightHBox.setBackgroundBonus(0);
                insightHBox.getSkillCheckBox().setVisible(true);
                survivalHBox.setBackgroundBonus(0);
                survivalHBox.getSkillCheckBox().setVisible(true);
                break;
            case "Noble":
                historyHBox.setBackgroundBonus(0);
                historyHBox.getSkillCheckBox().setVisible(true);
                persuasionHBox.setBackgroundBonus(0);
                persuasionHBox.getSkillCheckBox().setVisible(true);
                break;
            case "Outlander":
                athleticsHBox.setBackgroundBonus(0);
                athleticsHBox.getSkillCheckBox().setVisible(true);
                survivalHBox.setBackgroundBonus(0);
                survivalHBox.getSkillCheckBox().setVisible(true);
                break;
            case "Sage":
                arcanaHBox.setBackgroundBonus(0);
                arcanaHBox.getSkillCheckBox().setVisible(true);
                historyHBox.setBackgroundBonus(0);
                historyHBox.getSkillCheckBox().setVisible(true);
                break;
            case "Soldier":
                athleticsHBox.setBackgroundBonus(0);
                athleticsHBox.getSkillCheckBox().setVisible(true);
                intimidationHBox.setBackgroundBonus(0);
                intimidationHBox.getSkillCheckBox().setVisible(true);
                break;
            case "Urchin":
                sleightOfHandHBox.setBackgroundBonus(0);
                sleightOfHandHBox.getSkillCheckBox().setVisible(true);
                stealthHBox.setBackgroundBonus(0);
                stealthHBox.getSkillCheckBox().setVisible(true);
                break;
            case "Haunted One":
                intimidationHBox.setBackgroundBonus(0);
                intimidationHBox.getSkillCheckBox().setVisible(true);
                medicineHBox.setBackgroundBonus(0);
                medicineHBox.getSkillCheckBox().setVisible(true);
                break;
        }
        this.background = background;
        switch (this.background) {
            case "Acolyte":
                insightHBox.setBackgroundBonus(2);
                insightHBox.getSkillCheckBox().setVisible(false);
                religionHBox.setBackgroundBonus(2);
                religionHBox.getSkillCheckBox().setVisible(false);
                break;
            case "Charlatan":
                deceptionHBox.setBackgroundBonus(2);
                deceptionHBox.getSkillCheckBox().setVisible(false);
                sleightOfHandHBox.setBackgroundBonus(2);
                sleightOfHandHBox.getSkillCheckBox().setVisible(false);
                break;
            case "Criminal":
                deceptionHBox.setBackgroundBonus(2);
                deceptionHBox.getSkillCheckBox().setVisible(false);
                stealthHBox.setBackgroundBonus(2);
                stealthHBox.getSkillCheckBox().setVisible(false);
                break;
            case "Entertainer":
                acrobaticsHBox.setBackgroundBonus(2);
                acrobaticsHBox.getSkillCheckBox().setVisible(false);
                performanceHBox.setBackgroundBonus(2);
                performanceHBox.getSkillCheckBox().setVisible(false);
                break;
            case "Folk Hero":
                animalHandlingHBox.setBackgroundBonus(2);
                animalHandlingHBox.getSkillCheckBox().setVisible(false);
                survivalHBox.setBackgroundBonus(2);
                survivalHBox.getSkillCheckBox().setVisible(false);
                break;
            case "Guild Artisan":
                insightHBox.setBackgroundBonus(2);
                insightHBox.getSkillCheckBox().setVisible(false);
                survivalHBox.setBackgroundBonus(2);
                survivalHBox.getSkillCheckBox().setVisible(false);
                break;
            case "Noble":
                historyHBox.setBackgroundBonus(2);
                historyHBox.getSkillCheckBox().setVisible(false);
                persuasionHBox.setBackgroundBonus(2);
                persuasionHBox.getSkillCheckBox().setVisible(false);
                break;
            case "Outlander":
                athleticsHBox.setBackgroundBonus(2);
                athleticsHBox.getSkillCheckBox().setVisible(false);
                survivalHBox.setBackgroundBonus(2);
                survivalHBox.getSkillCheckBox().setVisible(false);
                break;
            case "Sage":
                arcanaHBox.setBackgroundBonus(2);
                arcanaHBox.getSkillCheckBox().setVisible(false);
                historyHBox.setBackgroundBonus(2);
                historyHBox.getSkillCheckBox().setVisible(false);
                break;
            case "Soldier":
                athleticsHBox.setBackgroundBonus(2);
                athleticsHBox.getSkillCheckBox().setVisible(false);
                intimidationHBox.setBackgroundBonus(2);
                intimidationHBox.getSkillCheckBox().setVisible(false);
                break;
            case "Urchin":
                sleightOfHandHBox.setBackgroundBonus(2);
                sleightOfHandHBox.getSkillCheckBox().setVisible(false);
                stealthHBox.setBackgroundBonus(2);
                stealthHBox.getSkillCheckBox().setVisible(false);
                break;
        }
        resetSkills();
    }

    private void setGender(String gender) {
        this.gender = gender;
        generateRandomName();
    }

    private void setPlayerClass(String playerClass) {
        switch (playerClass) {
            case "Barbarian":
                this.playerClass = "Barbarian";
                subclass = "Wildheart";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(barbarianSubclassChoiceBox);
                break;
            case "Bard":
                this.playerClass = "Bard";
                subclass = "Lore";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(bardSubclassChoiceBox);
                break;
            case "Cleric":
                this.playerClass = "Cleric";
                subclass = "Life";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(clericSubclassChoiceBox);
                break;
            case "Druid":
                this.playerClass = "Druid";
                subclass = "Circle of the Land";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(druidSubclassChoiceBox);
                break;
            case "Fighter":
                this.playerClass = "Fighter";
                subclass = "Battle Master";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(fighterSubclassChoiceBox);
                break;
            case "Monk":
                this.playerClass = "Monk";
                subclass = "Way of the Four Elements";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(monkSubclassChoiceBox);
                break;
            case "Paladin":
                this.playerClass = "Paladin";
                subclass = "Oath of the Ancients";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(paladinSubclassChoiceBox);
                break;
            case "Ranger":
                this.playerClass = "Ranger";
                subclass = "Beast Master";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(rangerSubclassChoiceBox);
                break;
            case "Rogue":
                this.playerClass = "Rogue";
                subclass = "Thief";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(rogueSubclassChoiceBox);
                break;
            case "Sorcerer":
                this.playerClass = "Sorcerer";
                subclass = "Wild Magic";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(sorcererSubclassChoiceBox);
                break;
            case "Warlock":
                this.playerClass = "Warlock";
                subclass = "The Fiend";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(warlockSubclassChoiceBox);
                break;
            case "Wizard":
                this.playerClass = "Wizard";
                subclass = "Abjuration";
                subclassHBox.getChildren().remove(1);
                subclassHBox.getChildren().add(wizardSubclassChoiceBox);
                break;
        }
        if (playerClass == "Cleric") {
            characterCustomizerAttributesVBox.getChildren().add(characterCustomizerAttributesVBox.getChildren().size() - 2, deityHBox);
            deityChoiceBox.setValue("Selune");
            deity = "Selune";
        }
        else {
            characterCustomizerAttributesVBox.getChildren().remove(deityHBox);
            deityChoiceBox.setValue("");
            deity = "";
        }
        resetSkills();
        resetClassCantrips();
        resetSpells();
    }

    private void setPlayerName(String playerName) { this.playerName = playerName; }

    private void setRace(String race) {
        if (subraceHBox.getChildren().size() == 2) {
            characterCustomizerAttributesVBox.getChildren().remove(subraceHBox);
            subraceHBox.getChildren().remove(1);
        }
        switch (race) {
            case "Elf":
                this.race = "Elf";
                subrace = "High Elf";
                elfSubraceChoiceBox.setValue("High Elf");
                subraceHBox.getChildren().add(elfSubraceChoiceBox);
                characterCustomizerAttributesVBox.getChildren().add(3, subraceHBox);
                break;
            case "Tiefling":
                this.race = "Tiefling";
                subrace = "Asmodeus Tiefling";
                tieflingSubraceChoiceBox.setValue("Asmodeus Tiefling");
                subraceHBox.getChildren().add(tieflingSubraceChoiceBox);
                characterCustomizerAttributesVBox.getChildren().add(3, subraceHBox);
                break;
            case "Drow":
                this.race = "Drow";
                subrace = "Lolth-Sworn Drow";
                drowSubraceChoiceBox.setValue("Lolth-Sworn Drow");
                subraceHBox.getChildren().add(drowSubraceChoiceBox);
                characterCustomizerAttributesVBox.getChildren().add(3, subraceHBox);
                break;
            case "Dwarf":
                this.race = "Dwarf";
                subrace = "Hill Dwarf";
                dwarfSubraceChoiceBox.setValue("Hill Dwarf");
                subraceHBox.getChildren().add(dwarfSubraceChoiceBox);
                characterCustomizerAttributesVBox.getChildren().add(3, subraceHBox);
                break;
            case "Half-Elf":
                this.race = "Half-Elf";
                subrace = "High Half-Elf";
                halfElfSubraceChoiceBox.setValue("High Half-Elf");
                subraceHBox.getChildren().add(halfElfSubraceChoiceBox);
                characterCustomizerAttributesVBox.getChildren().add(3, subraceHBox);
                break;
            case "Halfling":
                this.race = "Halfling";
                subrace = "Lightfoot Halfling";
                halflingSubraceChoiceBox.setValue("Lightfoot Halfling");
                subraceHBox.getChildren().add(halflingSubraceChoiceBox);
                characterCustomizerAttributesVBox.getChildren().add(3, subraceHBox);
                break;
            case "Gnome":
                this.race = "Gnome";
                subrace = "Rock Gnome";
                gnomeSubraceChoiceBox.setValue("Rock Gnome");
                historyHBox.setRaceBonus(4);
                subraceHBox.getChildren().add(gnomeSubraceChoiceBox);
                characterCustomizerAttributesVBox.getChildren().add(3, subraceHBox);
                break;
            case "Dragonborn":
                this.race = "Gnome";
                subrace = "Black Dragonborn";
                dragonbornSubraceChoiceBox.setValue("Black Dragonborn");
                subraceHBox.getChildren().add(dragonbornSubraceChoiceBox);
                characterCustomizerAttributesVBox.getChildren().add(3, subraceHBox);
                break;
            case "Human":
                this.race = "Human";
                subrace = "";
                break;
            case "Githyanki":
                this.race = "Githyanki";
            default:
                subrace = "";
        }
        if (subrace.equals("Rock Gnome") || background.equals("Noble") || background.equals("Sage")) historyHBox.getSkillCheckBox().setVisible(false);
        else historyHBox.getSkillCheckBox().setVisible(true);
        resetSkills();
        resetRaceCantrips();
        resetSpells();
    }

    private void setSubclass(String subclass) {
        this.subclass = subclass;
        resetSkills();
        resetSpells();
    }

    private void setSubrace(String subrace) {
        this.subrace = subrace;
        if (subrace.equals("Rock Gnome")) historyHBox.setRaceBonus(4);
        else historyHBox.setRaceBonus(0);
        if (subrace.equals("Rock Gnome") || background.equals("Noble") || background.equals("Sage")) historyHBox.getSkillCheckBox().setVisible(false);
        else historyHBox.getSkillCheckBox().setVisible(true);
        resetSkills();
        resetRaceCantrips();
        resetSpells();
    }

    private void resetClassCantrips() {
        classCantripsFlowPane.getChildren().clear();

        acidSplashClassButton.reset();
        bladeWardClassButton.reset();
        boneChillClassButton.reset();
        dancingLightsClassButton.reset();
        fireBoltClassButton.reset();
        friendsClassButton.reset();
        lightClassButton.reset();
        mageHandClassButton.reset();
        minorIllusionClassButton.reset();
        poisonSprayClassButton.reset();
        rayOfFrostClassButton.reset();
        shockingGraspClassButton.reset();
        trueStrikeClassButton.reset();
        viciousMockeryClassButton.reset();
        thaumaturgyClassButton.reset();
        sacredFlameClassButton.reset();
        guidanceClassButton.reset();
        resistanceClassButton.reset();
        produceFlameClassButton.reset();
        shillelaghClassButton.reset();
        thornWhipClassButton.reset();
        eldritchBlastClassButton.reset();

        switch (playerClass) {
            case "Bard":
                classCantripsFlowPane.getChildren().addAll(viciousMockeryClassButton, bladeWardClassButton, mageHandClassButton, trueStrikeClassButton, friendsClassButton, dancingLightsClassButton, lightClassButton, minorIllusionClassButton);
                remainingClassCantrips = 2;
                totalClassCantrips = 2;
                break;
            case "Cleric":
                classCantripsFlowPane.getChildren().addAll(thaumaturgyClassButton, sacredFlameClassButton, guidanceClassButton, resistanceClassButton, lightClassButton, bladeWardClassButton, produceFlameClassButton);
                remainingClassCantrips = 3;
                totalClassCantrips = 3;
                break;
            case "Druid":
                classCantripsFlowPane.getChildren().addAll(guidanceClassButton, poisonSprayClassButton, produceFlameClassButton, resistanceClassButton, shillelaghClassButton, thornWhipClassButton);
                remainingClassCantrips = 2;
                totalClassCantrips = 2;
                break;
            case "Ranger":
                classCantripsFlowPane.getChildren().addAll(trueStrikeClassButton, sacredFlameClassButton);
                remainingClassCantrips = 1;
                totalClassCantrips = 1;
                break;
            case "Sorcerer":
                classCantripsFlowPane.getChildren().addAll(acidSplashClassButton, bladeWardClassButton, boneChillClassButton, dancingLightsClassButton, fireBoltClassButton, friendsClassButton, lightClassButton, mageHandClassButton, minorIllusionClassButton, poisonSprayClassButton, rayOfFrostClassButton, shockingGraspClassButton, trueStrikeClassButton);
                remainingClassCantrips = 4;
                totalClassCantrips = 4;
                break;
            case "Warlock":
                classCantripsFlowPane.getChildren().addAll(bladeWardClassButton, boneChillClassButton, eldritchBlastClassButton, friendsClassButton, mageHandClassButton, minorIllusionClassButton, poisonSprayClassButton, trueStrikeClassButton);
                remainingClassCantrips = 2;
                totalClassCantrips = 2;
                break;
            case "Wizard":
                classCantripsFlowPane.getChildren().addAll(acidSplashClassButton, bladeWardClassButton, boneChillClassButton, dancingLightsClassButton, fireBoltClassButton, friendsClassButton, lightClassButton, mageHandClassButton, minorIllusionClassButton, poisonSprayClassButton, rayOfFrostClassButton, shockingGraspClassButton, trueStrikeClassButton);
                remainingClassCantrips = 3;
                totalClassCantrips = 3;
                break;
            default:
                remainingClassCantrips = 0;
                totalClassCantrips = 0;
                break;
        }

        switch (subclass) {
            case "Light Domain":
                classCantripsFlowPane.getChildren().add(lightClassButton);
                break;
            case "Nature Domain":
                classCantripsFlowPane.getChildren().add(shillelaghClassButton);
                break;
        }

        classCantripPointsLabel.setText("(" + remainingClassCantrips + "/" + totalClassCantrips + ")");
    }

    private void resetRaceCantrips() {
        raceCantripsFlowPane.getChildren().clear();

        acidSplashRaceButton.reset();
        bladeWardRaceButton.reset();
        boneChillRaceButton.reset();
        dancingLightsRaceButton.reset();
        fireBoltRaceButton.reset();
        friendsRaceButton.reset();
        lightRaceButton.reset();
        mageHandRaceButton.reset();
        minorIllusionRaceButton.reset();
        poisonSprayRaceButton.reset();
        rayOfFrostRaceButton.reset();
        shockingGraspRaceButton.reset();
        trueStrikeRaceButton.reset();
        produceFlameRaceButton.reset();
        thaumaturgyRaceButton.reset();
        githyankiMageHandButton.reset();

        switch (subrace) {
            case "High Elf", "High Half-Elf":
                raceCantripsFlowPane.getChildren().addAll(acidSplashRaceButton, bladeWardRaceButton, boneChillRaceButton, dancingLightsRaceButton, fireBoltRaceButton, friendsRaceButton, lightRaceButton, mageHandRaceButton, minorIllusionRaceButton, poisonSprayRaceButton, rayOfFrostRaceButton, shockingGraspRaceButton, trueStrikeRaceButton);
                remainingRaceCantrips = 1;
                totalRaceCantrips = 1;
                break;
            case "Asmodeus Tiefling":
                raceCantripsFlowPane.getChildren().add(produceFlameRaceButton);
                produceFlameRaceButton.setSelected();
                produceFlameRaceButton.getButton().setDisable(true);
                if (produceFlameClassButton.isSelected()) {
                    produceFlameClassButton.setSelected();
                    remainingClassCantrips++;
                    classCantripPointsLabel.setText("(" + remainingClassCantrips + "/" + totalClassCantrips + ")");
                }
                remainingRaceCantrips = 0;
                totalRaceCantrips = 1;
                break;
            case "Mephistopheles Tiefling":
                raceCantripsFlowPane.getChildren().add(mageHandRaceButton);
                mageHandRaceButton.setSelected();
                mageHandRaceButton.getButton().setDisable(true);
                if (mageHandClassButton.isSelected()) {
                    mageHandClassButton.setSelected();
                    remainingClassCantrips++;
                    classCantripPointsLabel.setText("(" + remainingClassCantrips + "/" + totalClassCantrips + ")");
                }
                remainingRaceCantrips = 0;
                totalRaceCantrips = 1;
                break;
            case "Zariel Tiefling":
                raceCantripsFlowPane.getChildren().add(thaumaturgyRaceButton);
                thaumaturgyRaceButton.setSelected();
                thaumaturgyRaceButton.getButton().setDisable(true);
                if (thaumaturgyClassButton.isSelected()) {
                    thaumaturgyClassButton.setSelected();
                    remainingClassCantrips++;
                    classCantripPointsLabel.setText("(" + remainingClassCantrips + "/" + totalClassCantrips + ")");
                }
                remainingRaceCantrips = 0;
                totalRaceCantrips = 1;
                break;
            case "Lolth-Sworn Drow", "Seldarine Drow", "Drow Half-Elf":
                raceCantripsFlowPane.getChildren().add(dancingLightsRaceButton);
                dancingLightsRaceButton.setSelected();
                dancingLightsRaceButton.getButton().setDisable(true);
                if (dancingLightsClassButton.isSelected()) {
                    dancingLightsClassButton.setSelected();
                    remainingClassCantrips++;
                    classCantripPointsLabel.setText("(" + remainingClassCantrips + "/" + totalClassCantrips + ")");
                }
                remainingRaceCantrips = 0;
                totalRaceCantrips = 1;
                break;
            default:
                remainingRaceCantrips = 0;
                totalRaceCantrips = 0;
                break;
        }

        if (race.equals("Githyanki")) {
            raceCantripsFlowPane.getChildren().add(githyankiMageHandButton);
            githyankiMageHandButton.setSelected();
            githyankiMageHandButton.getButton().setDisable(true);
            remainingRaceCantrips = 0;
            totalRaceCantrips = 1;
        }

        raceCantripPointsLabel.setText("(" + remainingRaceCantrips + "/" + totalRaceCantrips + ")");
    }

    private void resetSkills() {
        totalSkillPoints = 2;
        athleticsHBox.setSelectBonus(0);
        acrobaticsHBox.setSelectBonus(0);
        sleightOfHandHBox.setSelectBonus(0);
        stealthHBox.setSelectBonus(0);
        arcanaHBox.setSelectBonus(0);
        historyHBox.setSelectBonus(0);
        investigationHBox.setSelectBonus(0);
        natureHBox.setSelectBonus(0);
        religionHBox.setSelectBonus(0);
        animalHandlingHBox.setSelectBonus(0);
        insightHBox.setSelectBonus(0);
        medicineHBox.setSelectBonus(0);
        perceptionHBox.setSelectBonus(0);
        survivalHBox.setSelectBonus(0);
        deceptionHBox.setSelectBonus(0);
        intimidationHBox.setSelectBonus(0);
        performanceHBox.setSelectBonus(0);
        persuasionHBox.setSelectBonus(0);
        if (strengthHBox.getModifier() + athleticsHBox.getRaceBonus() + athleticsHBox.getSelectBonus() >= 0) athleticsHBox.getModifierLabel().setText("+" + Integer.toString(strengthHBox.getModifier() + athleticsHBox.getRaceBonus() + athleticsHBox.getBackgroundBonus() + athleticsHBox.getSelectBonus()));
        else athleticsHBox.getModifierLabel().setText(Integer.toString(strengthHBox.getModifier() + athleticsHBox.getRaceBonus() + athleticsHBox.getBackgroundBonus() + athleticsHBox.getSelectBonus()));
        if (dexterityHBox.getModifier() + acrobaticsHBox.getRaceBonus() + acrobaticsHBox.getSelectBonus() >= 0) acrobaticsHBox.getModifierLabel().setText("+" + Integer.toString(dexterityHBox.getModifier() + acrobaticsHBox.getRaceBonus() + acrobaticsHBox.getBackgroundBonus() + acrobaticsHBox.getSelectBonus()));
        else acrobaticsHBox.getModifierLabel().setText(Integer.toString(dexterityHBox.getModifier() + acrobaticsHBox.getRaceBonus() + acrobaticsHBox.getBackgroundBonus() + acrobaticsHBox.getSelectBonus()));
        if (dexterityHBox.getModifier() + sleightOfHandHBox.getRaceBonus() + sleightOfHandHBox.getSelectBonus() >= 0) sleightOfHandHBox.getModifierLabel().setText("+" + Integer.toString(dexterityHBox.getModifier() + sleightOfHandHBox.getRaceBonus() + sleightOfHandHBox.getBackgroundBonus() + sleightOfHandHBox.getSelectBonus()));
        else sleightOfHandHBox.getModifierLabel().setText(Integer.toString(dexterityHBox.getModifier() + sleightOfHandHBox.getRaceBonus() + sleightOfHandHBox.getBackgroundBonus() + sleightOfHandHBox.getSelectBonus()));
        if (dexterityHBox.getModifier() + stealthHBox.getRaceBonus() + stealthHBox.getSelectBonus() >= 0) stealthHBox.getModifierLabel().setText("+" + Integer.toString(dexterityHBox.getModifier() + stealthHBox.getRaceBonus() + stealthHBox.getBackgroundBonus() + stealthHBox.getSelectBonus()));
        else stealthHBox.getModifierLabel().setText(Integer.toString(dexterityHBox.getModifier() + stealthHBox.getRaceBonus() + stealthHBox.getBackgroundBonus() + stealthHBox.getSelectBonus()));
        if (intelligenceHBox.getModifier() + arcanaHBox.getRaceBonus() + arcanaHBox.getSelectBonus() >= 0) arcanaHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + arcanaHBox.getRaceBonus() + arcanaHBox.getBackgroundBonus() + arcanaHBox.getSelectBonus()));
        else arcanaHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + arcanaHBox.getRaceBonus() + arcanaHBox.getBackgroundBonus() + arcanaHBox.getSelectBonus()));
        if (intelligenceHBox.getModifier() + historyHBox.getRaceBonus() + historyHBox.getSelectBonus() >= 0) historyHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + historyHBox.getRaceBonus() + historyHBox.getBackgroundBonus() + historyHBox.getSelectBonus()));
        else historyHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + historyHBox.getRaceBonus() + historyHBox.getBackgroundBonus() + historyHBox.getSelectBonus()));
        if (intelligenceHBox.getModifier() + investigationHBox.getRaceBonus() + investigationHBox.getSelectBonus() >= 0) investigationHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + investigationHBox.getRaceBonus() + investigationHBox.getBackgroundBonus() + investigationHBox.getSelectBonus()));
        else investigationHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + investigationHBox.getRaceBonus() + investigationHBox.getBackgroundBonus() + investigationHBox.getSelectBonus()));
        if (intelligenceHBox.getModifier() + natureHBox.getRaceBonus() + natureHBox.getSelectBonus() >= 0) natureHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + natureHBox.getRaceBonus() + natureHBox.getBackgroundBonus() + natureHBox.getSelectBonus()));
        else natureHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + natureHBox.getRaceBonus() + natureHBox.getBackgroundBonus() + natureHBox.getSelectBonus()));
        if (intelligenceHBox.getModifier() + religionHBox.getRaceBonus() + religionHBox.getSelectBonus() >= 0) religionHBox.getModifierLabel().setText("+" + Integer.toString(intelligenceHBox.getModifier() + religionHBox.getRaceBonus() + religionHBox.getBackgroundBonus() + religionHBox.getSelectBonus()));
        else religionHBox.getModifierLabel().setText(Integer.toString(intelligenceHBox.getModifier() + religionHBox.getRaceBonus() + religionHBox.getBackgroundBonus() + religionHBox.getSelectBonus()));
        if (wisdomHBox.getModifier() + animalHandlingHBox.getRaceBonus() + animalHandlingHBox.getSelectBonus() >= 0) animalHandlingHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + animalHandlingHBox.getRaceBonus() + animalHandlingHBox.getBackgroundBonus() + animalHandlingHBox.getSelectBonus()));
        else animalHandlingHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + animalHandlingHBox.getRaceBonus() + animalHandlingHBox.getBackgroundBonus() + animalHandlingHBox.getSelectBonus()));
        if (wisdomHBox.getModifier() + insightHBox.getRaceBonus() + insightHBox.getSelectBonus() >= 0) insightHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + insightHBox.getRaceBonus() + insightHBox.getBackgroundBonus() + insightHBox.getSelectBonus()));
        else insightHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + insightHBox.getRaceBonus() + insightHBox.getBackgroundBonus() + insightHBox.getSelectBonus()));
        if (wisdomHBox.getModifier() + medicineHBox.getRaceBonus() + medicineHBox.getSelectBonus() >= 0) medicineHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + medicineHBox.getRaceBonus() + medicineHBox.getBackgroundBonus() + medicineHBox.getSelectBonus()));
        else medicineHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + medicineHBox.getRaceBonus()+ medicineHBox.getBackgroundBonus() + medicineHBox.getSelectBonus()));
        if (wisdomHBox.getModifier() + perceptionHBox.getRaceBonus() + perceptionHBox.getSelectBonus() >= 0) perceptionHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + perceptionHBox.getRaceBonus() + perceptionHBox.getBackgroundBonus() + perceptionHBox.getSelectBonus()));
        else perceptionHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + perceptionHBox.getRaceBonus() + perceptionHBox.getBackgroundBonus() + perceptionHBox.getSelectBonus()));
        if (wisdomHBox.getModifier() + survivalHBox.getRaceBonus() + survivalHBox.getSelectBonus() >= 0) survivalHBox.getModifierLabel().setText("+" + Integer.toString(wisdomHBox.getModifier() + survivalHBox.getRaceBonus() + survivalHBox.getBackgroundBonus() + survivalHBox.getSelectBonus()));
        else survivalHBox.getModifierLabel().setText(Integer.toString(wisdomHBox.getModifier() + survivalHBox.getRaceBonus() + survivalHBox.getBackgroundBonus() + survivalHBox.getSelectBonus()));
        if (charismaHBox.getModifier() + deceptionHBox.getRaceBonus() + deceptionHBox.getSelectBonus() >= 0) deceptionHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + deceptionHBox.getRaceBonus() + deceptionHBox.getBackgroundBonus() + deceptionHBox.getSelectBonus()));
        else deceptionHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + deceptionHBox.getRaceBonus() + deceptionHBox.getBackgroundBonus() + deceptionHBox.getSelectBonus()));
        if (charismaHBox.getModifier() + intimidationHBox.getRaceBonus() + intimidationHBox.getSelectBonus() >= 0) intimidationHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + intimidationHBox.getRaceBonus() + intimidationHBox.getBackgroundBonus() + intimidationHBox.getSelectBonus()));
        else intimidationHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + intimidationHBox.getRaceBonus() + deceptionHBox.getBackgroundBonus()+ intimidationHBox.getSelectBonus()));
        if (charismaHBox.getModifier() + performanceHBox.getRaceBonus() + performanceHBox.getSelectBonus() >= 0) performanceHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + performanceHBox.getRaceBonus() + performanceHBox.getBackgroundBonus() + performanceHBox.getSelectBonus()));
        else performanceHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + performanceHBox.getRaceBonus() + performanceHBox.getBackgroundBonus() + performanceHBox.getSelectBonus()));
        if (charismaHBox.getModifier() + persuasionHBox.getRaceBonus() + persuasionHBox.getSelectBonus() >= 0) persuasionHBox.getModifierLabel().setText("+" + Integer.toString(charismaHBox.getModifier() + persuasionHBox.getRaceBonus() + persuasionHBox.getBackgroundBonus() + persuasionHBox.getSelectBonus()));
        else persuasionHBox.getModifierLabel().setText(Integer.toString(charismaHBox.getModifier() + persuasionHBox.getRaceBonus() + persuasionHBox.getBackgroundBonus() + persuasionHBox.getSelectBonus()));
        athleticsHBox.getSkillCheckBox().setSelected(false);
        acrobaticsHBox.getSkillCheckBox().setSelected(false);
        sleightOfHandHBox.getSkillCheckBox().setSelected(false);
        stealthHBox.getSkillCheckBox().setSelected(false);
        arcanaHBox.getSkillCheckBox().setSelected(false);
        historyHBox.getSkillCheckBox().setSelected(false);
        investigationHBox.getSkillCheckBox().setSelected(false);
        natureHBox.getSkillCheckBox().setSelected(false);
        religionHBox.getSkillCheckBox().setSelected(false);
        animalHandlingHBox.getSkillCheckBox().setSelected(false);
        insightHBox.getSkillCheckBox().setSelected(false);
        medicineHBox.getSkillCheckBox().setSelected(false);
        perceptionHBox.getSkillCheckBox().setSelected(false);
        survivalHBox.getSkillCheckBox().setSelected(false);
        deceptionHBox.getSkillCheckBox().setSelected(false);
        intimidationHBox.getSkillCheckBox().setSelected(false);
        performanceHBox.getSkillCheckBox().setSelected(false);
        persuasionHBox.getSkillCheckBox().setSelected(false);
        if (this.race.equals("Human")) totalSkillPoints = totalSkillPoints + 1;
        if (playerClass.equals("Rogue")) totalSkillPoints = totalSkillPoints + 4;
        if (subrace.equals("Rock Gnome")) historyHBox.setRaceBonus(4);
        else historyHBox.setRaceBonus(0);
        remainingSkillPoints = totalSkillPoints;
        skillPointsLabel.setText("(" + remainingSkillPoints + "/" + totalSkillPoints + ")");
    }

    private void resetSpells() {
        spellsFlowPane.getChildren().clear();

        animalFriendshipSpellButton.reset();
        armourOfAgathysSpellButton.reset();
        armsOfHadarSpellButton.reset();
        baneSpellButton.reset();
        burningHandsSpellButton.reset();
        charmPersonSpellButton.reset();
        chromaticOrbSpellButton.reset();
        colourSpraySpellButton.reset();
        commandSpellButton.reset();
        cureWoundsSpellButton.reset();
        disguiseSelfSpellButton.reset();
        dissonantWhispersSpellButton.reset();
        divineFavourSpellButton.reset();
        enhanceLeapSpellButton.reset();
        expeditiousRetreatSpellButton.reset();
        faerieFireSpellButton.reset();
        falseLifeSpellButton.reset();
        featherFallSpellButton.reset();
        findFamiliarSpellButton.reset();
        fogCloudSpellButton.reset();
        greaseSpellButton.reset();
        guidingBoltSpellButton.reset();
        healingWordSpellButton.reset();
        hellishRebukeSpellButton.reset();
        heroismSpellButton.reset();
        iceKnifeSpellButton.reset();
        inflictWoundsSpellButton.reset();
        longstriderSpellButton.reset();
        mageArmourSpellButton.reset();
        magicMissileSpellButton.reset();
        protectionFromEvilAndGoodSpellButton.reset();
        rayOfSicknessSpellButton.reset();
        shieldSpellButton.reset();
        shieldOfFaithSpellButton.reset();
        sleepSpellButton.reset();
        speakWithAnimalsSpellButton.reset();
        tashasHideousLaughterSpellButton.reset();
        thunderwaveSpellButton.reset();
        witchboltSpellButton.reset();
        sanctuarySpellButton.reset();
        blessSpellButton.reset();
        createOrDestroyWaterSpellButton.reset();
        goodberrySpellButton.reset();
        hexSpellButton.reset();
        entangleSpellButton.reset();

        if (subrace.equals("Forest Gnome")) {
            spellsFlowPane.getChildren().add(speakWithAnimalsSpellButton);
            speakWithAnimalsSpellButton.setSelected();
            speakWithAnimalsSpellButton.getButton().setDisable(true);
        }

        switch (playerClass) {
            case "Bard":
                spellsFlowPane.getChildren().addAll(animalFriendshipSpellButton, baneSpellButton, charmPersonSpellButton, cureWoundsSpellButton, disguiseSelfSpellButton, dissonantWhispersSpellButton, faerieFireSpellButton, featherFallSpellButton, healingWordSpellButton, heroismSpellButton, longstriderSpellButton, sleepSpellButton);
                if (!subrace.equals("Forest Gnome")) spellsFlowPane.getChildren().add(speakWithAnimalsSpellButton);
                spellsFlowPane.getChildren().addAll(tashasHideousLaughterSpellButton, thunderwaveSpellButton);
                remainingSpellPoints = 4;
                totalSpellPoints = 4;
                break;
            case "Cleric":
                spellsFlowPane.getChildren().addAll(shieldOfFaithSpellButton, protectionFromEvilAndGoodSpellButton, sanctuarySpellButton, baneSpellButton, commandSpellButton, blessSpellButton, cureWoundsSpellButton, healingWordSpellButton, guidingBoltSpellButton, inflictWoundsSpellButton, createOrDestroyWaterSpellButton);
                remainingSpellPoints = 4;
                totalSpellPoints = 4;
                break;
            case "Druid":
                spellsFlowPane.getChildren().addAll(iceKnifeSpellButton, entangleSpellButton, fogCloudSpellButton);
                if (!subrace.equals("Forest Gnome")) spellsFlowPane.getChildren().add(speakWithAnimalsSpellButton);
                spellsFlowPane.getChildren().addAll(animalFriendshipSpellButton, charmPersonSpellButton, thunderwaveSpellButton, healingWordSpellButton, cureWoundsSpellButton, faerieFireSpellButton, enhanceLeapSpellButton, longstriderSpellButton, goodberrySpellButton, createOrDestroyWaterSpellButton);
                remainingSpellPoints = 4;
                totalSpellPoints = 4;
                break;
            case "Sorcerer":
                spellsFlowPane.getChildren().addAll(burningHandsSpellButton, charmPersonSpellButton, chromaticOrbSpellButton, colourSpraySpellButton, disguiseSelfSpellButton, expeditiousRetreatSpellButton, falseLifeSpellButton, featherFallSpellButton, fogCloudSpellButton, iceKnifeSpellButton, enhanceLeapSpellButton, mageArmourSpellButton, magicMissileSpellButton, rayOfSicknessSpellButton, shieldSpellButton, sleepSpellButton, thunderwaveSpellButton, witchboltSpellButton);
                remainingSpellPoints = 2;
                totalSpellPoints = 2;
                break;
            case "Warlock":
                spellsFlowPane.getChildren().addAll(armourOfAgathysSpellButton, armsOfHadarSpellButton, burningHandsSpellButton, charmPersonSpellButton, commandSpellButton, expeditiousRetreatSpellButton, hellishRebukeSpellButton, hexSpellButton, protectionFromEvilAndGoodSpellButton, witchboltSpellButton);
                remainingSpellPoints = 2;
                totalSpellPoints = 2;
                break;
            case "Wizard":
                spellsFlowPane.getChildren().addAll(burningHandsSpellButton, charmPersonSpellButton, chromaticOrbSpellButton, colourSpraySpellButton, disguiseSelfSpellButton, expeditiousRetreatSpellButton, falseLifeSpellButton, featherFallSpellButton, findFamiliarSpellButton, fogCloudSpellButton, greaseSpellButton, iceKnifeSpellButton, enhanceLeapSpellButton, longstriderSpellButton, mageArmourSpellButton, magicMissileSpellButton, protectionFromEvilAndGoodSpellButton, rayOfSicknessSpellButton, shieldSpellButton, sleepSpellButton, tashasHideousLaughterSpellButton, thunderwaveSpellButton, witchboltSpellButton);
                remainingSpellPoints = 10;
                totalSpellPoints = 10;
                break;
        }

        switch (subclass) {
            case "Light Domain":
                spellsFlowPane.getChildren().addAll(burningHandsSpellButton, faerieFireSpellButton);
                burningHandsSpellButton.setSelected();
                burningHandsSpellButton.getButton().setDisable(true);
                faerieFireSpellButton.setSelected();
                faerieFireSpellButton.getButton().setDisable(true);
                break;
            case "Trickery Domain":
                spellsFlowPane.getChildren().addAll(charmPersonSpellButton, disguiseSelfSpellButton);
                charmPersonSpellButton.setSelected();
                charmPersonSpellButton.getButton().setDisable(true);
                disguiseSelfSpellButton.setSelected();
                disguiseSelfSpellButton.getButton().setDisable(true);
                break;
            case "Knowledge Domain":
                spellsFlowPane.getChildren().add(sleepSpellButton);
                sleepSpellButton.setSelected();
                sleepSpellButton.getButton().setDisable(true);
                break;
            case "Nature Domain":
                if (!subrace.equals("Forest Gnome")) {
                    spellsFlowPane.getChildren().add(speakWithAnimalsSpellButton);
                    speakWithAnimalsSpellButton.setSelected();
                }
                spellsFlowPane.getChildren().add(animalFriendshipSpellButton);
                animalFriendshipSpellButton.setSelected();
                speakWithAnimalsSpellButton.getButton().setDisable(true);
                animalFriendshipSpellButton.getButton().setDisable(true);
                break;
            case "Tempest Domain":
                spellsFlowPane.getChildren().addAll(thunderwaveSpellButton, fogCloudSpellButton);
                thunderwaveSpellButton.setSelected();
                thunderwaveSpellButton.getButton().setDisable(true);
                fogCloudSpellButton.setSelected();
                fogCloudSpellButton.getButton().setDisable(true);
                break;
            case "War Domain":
                spellsFlowPane.getChildren().add(divineFavourSpellButton);
                divineFavourSpellButton.setSelected();
                divineFavourSpellButton.getButton().setDisable(true);
                break;
        }

        spellsPointsLabel.setText("(" + remainingSpellPoints + "/" + totalSpellPoints + ")");
    }
}