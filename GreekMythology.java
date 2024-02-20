import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;

public class GreekMythology extends Application {
    TabPane TabPane = new TabPane();
    Pane mainPane = new Pane();
    VBox vBoxForGods = new VBox(20);
    VBox vBoxForGodPics = new VBox(20);
    ArrayList<String> godsList = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception {
        godsInfo();
        textAndTabsForGods();
        textAndPaneForHeroes();

        Scene scene = new Scene(TabPane, 825, 500);
        primaryStage.setTitle("Greek Gods");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void godsInfo() {
        Label zeus = new Label("Zeus");
        godsList.add("Zeus was recognized as the father of gods and humans. He regulated the celestial phenomena and\n" +
                "defined the laws that govern people. He held the lightning bolt with one hand and the scepter with\n" +
                "the other, which had an eagle at the top. He was known as the ‘Lord of Justice’. People respected\n" +
                "and feared him at the same time. He was taking care of the families, keeping vigil in the home of\n" +
                "every mortal and protecting strangers and passers-by from evil. Zeus' wife was the goddess Hera, to\n" +
                "whom he was not always faithful. Greek mythology is full of love stories about Zeus, who liked to\n" +
                "transform himself into anything he could think of and mingle with other goddesses or mortals.");
        Label poseidon = new Label("Poseidon");
        godsList.add("Poseidon is the Greek god of the seas.\n" +
                "He is known for protecting the sailors, but he will also inflict his wrath on those who he feels has\n" +
                "done him wrong. He had a love affair with Medusa, who birthed his two children when Perseus beheaded\n" +
                "her. Poseidon was one of the six children of Cronus and Rhea and brother of Zeus. He was allotted the\n" +
                "kingdom of the sea but he was also considered the god of horses and earthquakes. This is why he was\n" +
                "called “the earth-shaker”. He rarely lived on Olympus, preferring the depths of the ocean. He was\n" +
                "sitting on a famous chariot drawn by immortal horses and holding in his hand the famous trident,\n" +
                "forged by the Cyclops. When Poseidon was angry, he plunged the trident into the sea and shook it whole\n" +
                "from end to end. The sailors prayed to Poseidon so that he spares them from his wrath.");
        Label hera = new Label("Hera");
        godsList.add("The queen goddess of Olympus, Hera was both sister and wife to Zeus. Though she is often depicted\n" +
                "as reserved and austere, she was mercilessly vindictive when it came to her husband’s [many] extramarital\n" +
                "adventures. Unfortunately for the objects of Zeus’s godly affections, Hera tended to torment the\n" +
                "\"other women\"(and their offspring, including Heracles) rather than Zeus himself. Hera symbolized and\n" +
                "protected the sacred institution of marriage. She blessed and helped the women in labor. There are almost no\n" +
                "myths that refer exclusively to Hera. Her name is almost always associated with the myths about Zeus.\n" +
                "However, Hera does not present herself as a goddess submissive to her sovereign husband. She had a strong\n" +
                "female personality and she was the only one that dared to object to him.\n");
        Label demeter = new Label("Demeter");
        godsList.add("Demeter is the Greek goddess of agriculture, harvest, and fertility of the earth. Demeter brings\n" +
                "drought and famine upon the earth when Hades steals her daughter, Persephone, from the earth and takes\n" +
                "her to the underworld. She vows the earth will continue to be barren unless Hades returns Persephone to\n" +
                "the earth. She was the first to make the earth fruitful and taught people how to grow wheat, barley and\n" +
                "other plants. Demeter is somewhat isolated from the twelve gods in ancient myths and this is because she\n" +
                "is an even more ancient goddess herself. The most sacred and secret religious rites of ancient Greece,\n" +
                "the Eleusinian Mysteries, were held in honor of Demeter.");
        Label athena = new Label("Athena");
        godsList.add("Athena is the Greek goddess of wisdom and knowledge. She is born from the head of\n" +
                "Zeus after he swallowed Athena’s mother when she was pregnant. She was born fully grown\n" +
                "and dressed in armor. Athens, Greece, is named after Athena because of her close ties to\n" +
                "the city and civilization.");
        Label apollo = new Label("Apollo");
        godsList.add("Apollo is the Greek god of healing, medicine, music, and poetry. He is most associated with the Lyre,\n" +
                "a musical instrument made by fellow Olympian, Hermes. Hermes stole several of Apollo’s cattle. When Apollo\n" +
                "noticed his cattle were missing, he confronted Hermes. Hermes began playing music on the Lyre that he made.\n" +
                "Apollo being the god of music, was captivated by the music and allowed Hermes to keep his cattle in exchange\n" +
                "for the musical instrument. Apollo and Artemis were siblings, twins actually, children of Zeus and Leto, a\n" +
                "Titan goddess. According to tradition, the two children were born on the island of Delos. Apollo is one of\n" +
                "the most important and complex Greek gods. He is the god of light, music and poetry, healing and prophecy.\n" +
                "He was the one that established the great Oracle of Delphi, which was considered the center of the ancient\n" +
                "world. He was the teacher of the nine Muses and when they sang he accompanied them with his famous lyre.");
        Label artemis = new Label("Artemis");
        godsList.add("Artemis is the Greek goddess of animals and hunting. She is often depicted with a bow and arrow, the\n" +
                "weapon she would use when hunting. Tragically, she would kill her best friend, Orion, with this same bow\n" +
                "and arrow after Apollo convinces her that Orion is a villain who is attempting to escape the area after\n" +
                "raping a friend of Artemis. She spent her time in the woods, accompanied by the Nymphs, hunting, with her\n" +
                "bow and arrows. She was a virgin goddess and protector of young girls. She was also worshipped as one of the\n" +
                "primary goddesses of childbirth and midwifery, relieving the women in labor from diseases. She was sometimes\n" +
                "associated with the goddess of the moon.");
        Label ares = new Label("Ares");
        godsList.add("Ares is the Greek god of war. He has two sons, Phobos and Deimos, who represent fear and terror.\n" +
                "His sons often accompany Ares by driving him in his chariot on the way to war. Ares, the god of war,\n" +
                "was the son of the Greek gods Zeus and Hera. Ares was handsome and strong, young and well-armed. He loved\n" +
                "war and battles so he was hated by people and his worship was limited. Only in Sparta he was particularly\n" +
                "worshipped and had a statue dedicated to him. Ares was tried, according to tradition, for his many war\n" +
                "crimes, in one of Athens’ hills, the Areopagus Hill, which later became the seat of the criminal court\n" +
                "of ancient Athens.");
        Label aphrodite = new Label("Aphrodite");
        godsList.add("Aphrodite is the Greek goddess of love, beauty, pleasure, and relationships. She often wears a sacred\n" +
                "belt that she sometimes lends out. Aphrodite was known for her beauty. Aphrodite, the most beautiful among\n" +
                "mortals and immortals, was born from the foam of the sea when Uranus’ blood fell on it after his defeat by\n" +
                "Cronus. This fact makes her the eldest among the Olympian Gods. Her name literally means “risen from the foam”.\n" +
                "Aphrodite was worshipped as the goddess of beauty and passion. She could inspire love in the hearts of men and\n" +
                "women. Most myths generally present Aphrodite as a vengeful woman. Aphrodite was worshiped in all parts of\n" +
                "Greece and many priestesses were serving her. According to Greek mythology, she married the god of fire and\n" +
                "blacksmiths, Hephaestus, but she was in love with the god of war, Ares, with whom she bared many children\n" +
                "among which the winged god of love, Eros");
        Label hephaestus = new Label("Hephaestus");
        godsList.add("Hephaestus was the Greek god of blacksmithing, metalworking, and craftsmanship. He would make all\n" +
                "of the weapons and armor for Mount Olympus. He is associated with an anvil, donkey, and volcano. Hephaestus\n" +
                "was the god of fire and blacksmiths. He was born ugly and that is why his mother, the goddess Hera, unable\n" +
                "to nourish him, threw him out of Olympus. Since then he has been limping. Hephaestus fell into the sea,\n" +
                "where he was picked up by the Nereids and raised by them. Growing up, he became a famous craftsman and\n" +
                "set up his workshop on Mount Etna in Sicily. With his various metals, he made works of art of incomparable\n" +
                "beauty. He once made a golden throne and sent it to his mother Hera. As soon as Hera sat down, invisible\n" +
                "chains bound her without anyone being able to untie them. They tried to persuade Hephaestus, but they only\n" +
                "succeeded after they got him drunk first. Hephaestus, the god of fire, gave his name to the volcanoes in\n" +
                "the Greek language. It was from him, that the Titan Prometheus took the fire and gave it to the people.\n" +
                "Hephaestus was also the one who built the brass and gold palaces of Olympus.");
        Label hermes = new Label("Hermes");
        godsList.add("Hermes is the Greek god of travel, athletes, sports, mischief, and trade. Hermes was considered the\n" +
                "the Messenger God, being the herald of the Olympians and carrying messages between them. He was the son\n" +
                "of Zeus and Maia, daughter of Titan Atlas.Hermes delivered the message to Hades that Demeter requested he\n" +
                "releases Persephone back to the earth. He was a clever, inventive and arrogant god. As soon as he was born,\n" +
                "Hermes saw a turtle. He took her shell, placed seven strings in it and invented the lyre. He once stole\n" +
                "the oxen guarded by god Apollo and locked them in a cave. He wouldn’t admit the theft, but in the end,\n" +
                "he confessed. To avoid punishment, he gifted the lyre to Apollo. Hermes wore winged sandals and held the\n" +
                "caduceus, his wand which had two serpents twined around it. He was the one who accompanied the souls of\n" +
                "the dead to Hades and for that, he was known as the “soul-bearer”.");
        Label hestia = new Label("Hestia");
        godsList.add("Hestia is the Greek goddess of the hearth and home. She was a virgin goddess and never married. She\n" +
                "always kept the fire burning in the hearth of Mount Olympus, and all food was sacrificed to her in her\n" +
                "name for her service to the Olympians.");
        Label dionysus = new Label("Dionysus");
        godsList.add("Dionysus is the Greek god of wine. He was often considered an outsider of the Twelve Olympians because\n" +
                "he had a mortal mother. Because of his connection to wine, Dionysus was happy during the harvest months and\n" +
                "was feeble during the winter months");
        vBoxForGods.getChildren().addAll(zeus, poseidon, hera, demeter, athena, apollo, artemis, ares, aphrodite, hephaestus,
                hermes, hestia, dionysus);
    }
    public void textAndTabsForGods() {
        ScrollPane sp = new ScrollPane(vBoxForGodPics);

        Text zeusText = new Text(godsList.get(0));
        Text poseidonText = new Text(godsList.get(1));
        Text heraText = new Text(godsList.get(2));
        Text demeterText = new Text(godsList.get(3));
        Text athenaText = new Text(godsList.get(4));
        Text apolloText = new Text(godsList.get(5));
        Text artemisText = new Text(godsList.get(6));
        Text aresText = new Text(godsList.get(7));
        Text aphroditeText = new Text(godsList.get(8));
        Text hephaestusText = new Text(godsList.get(9));
        Text hermesText = new Text(godsList.get(10));
        Text hestiaText = new Text(godsList.get(11));
        Text dionysusText = new Text(godsList.get(12));

        Tab allGods = new Tab("Gods");
        allGods.setContent(sp);
        Tab zeusTab = new Tab("Zeus");
        zeusTab.setContent(zeusText);
        Tab poseidonTab = new Tab("Poseidon");
        poseidonTab.setContent(poseidonText);
        Tab heraTab = new Tab("Hera");
        heraTab.setContent(heraText);
        Tab demeterTab = new Tab("Demeter");
        demeterTab.setContent(demeterText);
        Tab athenaTab = new Tab("Athena");
        athenaTab.setContent(athenaText);
        Tab apolloTab = new Tab("Apollo");
        apolloTab.setContent(apolloText);
        Tab artmeisTab = new Tab("Artemis");
        artmeisTab.setContent(artemisText);
        Tab aresTab = new Tab("Ares");
        aresTab.setContent(aresText);
        Tab aphroditeTab = new Tab("Aphrodite");
        aphroditeTab.setContent(aphroditeText);
        Tab hephaestusTab = new Tab("Hephaestus");
        hephaestusTab.setContent(hephaestusText);
        Tab hermesTab = new Tab("Hermes");
        hermesTab.setContent(hermesText);
        Tab hestiaTab = new Tab("Hestia");
        hestiaTab.setContent(hestiaText);
        Tab dionysusTab = new Tab("Dionysus");
        dionysusTab.setContent(dionysusText);

        Text zeusPicText = new Text("Zeus");
        File zeusFile = new File("Zeus.jpg");
        Image zeus = new Image(zeusFile.toURI().toString());
        ImageView zeusPic = new ImageView(zeus);
        zeusPic.setFitHeight(150);
        zeusPic.setFitWidth(100);
        Text poseidonPicText = new Text("Poseidon");
        File poseidonFile = new File("Poseidon.jpg");
        Image poseidon = new Image(poseidonFile.toURI().toString());
        ImageView poseidonPic = new ImageView(poseidon);
        poseidonPic.setFitHeight(150);
        poseidonPic.setFitWidth(100);
        Text heraPicText = new Text("Hera");
        File heraFile = new File("Hera.jpg");
        Image hera = new Image(heraFile.toURI().toString());
        ImageView heraPic = new ImageView(hera);
        heraPic.setFitHeight(150);
        heraPic.setFitWidth(100);
        Text demeterPicText = new Text("Demeter");
        File demeterFile = new File("Demeter.jpg");
        Image demeter = new Image(demeterFile.toURI().toString());
        ImageView demeterPic = new ImageView(demeter);
        demeterPic.setFitHeight(150);
        demeterPic.setFitWidth(100);
        Text athenaPicText = new Text("Athena");
        File athenaFile = new File("Athena.jpg");
        Image athena = new Image(athenaFile.toURI().toString());
        ImageView athenaPic = new ImageView(athena);
        athenaPic.setFitHeight(150);
        athenaPic.setFitWidth(100);
        Text apolloPicText = new Text("Apollo");
        File apolloFile = new File("Apollo.jpg");
        Image apollo = new Image(apolloFile.toURI().toString());
        ImageView apolloPic = new ImageView(apollo);
        apolloPic.setFitHeight(150);
        apolloPic.setFitWidth(100);
        Text artemisPicText = new Text("Artemis");
        File artemisFile = new File("Artemis.jpg");
        Image artemis = new Image(artemisFile.toURI().toString());
        ImageView artemisPic = new ImageView(artemis);
        artemisPic.setFitHeight(150);
        artemisPic.setFitWidth(100);
        Text aresPicText = new Text("Ares");
        File aresFile = new File("Ares.jpg");
        Image ares = new Image(aresFile.toURI().toString());
        ImageView aresPic = new ImageView(ares);
        aresPic.setFitHeight(150);
        aresPic.setFitWidth(100);
        Text aphroditePicText = new Text("Aphrodite");
        File aphroditeFile = new File("Aphrodite.jpg");
        Image aphrodite = new Image(aphroditeFile.toURI().toString());
        ImageView aphroditePic = new ImageView(aphrodite);
        aphroditePic.setFitHeight(150);
        aphroditePic.setFitWidth(100);
        Text hephaestusPicText = new Text("Hephaestus");
        File hephaestusFile = new File("Hephaestus.jpg");
        Image hephaestus = new Image(hephaestusFile.toURI().toString());
        ImageView hephaestusPic = new ImageView(hephaestus);
        hephaestusPic.setFitHeight(150);
        hephaestusPic.setFitWidth(100);
        Text hermesPicText = new Text("Hermes");
        File hermesFile = new File("Hermes.jpg");
        Image hermes = new Image(hermesFile.toURI().toString());
        ImageView hermesPic = new ImageView(hermes);
        hermesPic.setFitHeight(150);
        hermesPic.setFitWidth(100);
        Text hestiaPicText = new Text("Hestia");
        File hestiaFile = new File("Hestia.jpg");
        Image hestia = new Image(hestiaFile.toURI().toString());
        ImageView hestiaPic = new ImageView(hestia);
        hestiaPic.setFitHeight(150);
        hestiaPic.setFitWidth(100);
        Text dionysusPicText = new Text("Dionysus");
        File dionysusFile = new File("Dionysus.jpg");
        Image dionysus = new Image(dionysusFile.toURI().toString());
        ImageView dionysusPic = new ImageView(dionysus);
        dionysusPic.setFitHeight(150);
        dionysusPic.setFitWidth(100);
        vBoxForGodPics.setAlignment(Pos.CENTER_LEFT);
        vBoxForGodPics.getChildren().addAll(zeusPicText, zeusPic, poseidonPicText, poseidonPic, heraPicText, heraPic,
                demeterPicText, demeterPic, athenaPicText, athenaPic, apolloPicText, apolloPic, artemisPicText, artemisPic,
                aresPicText, aresPic, aphroditePicText, aphroditePic, hephaestusPicText, hephaestusPic, hermesPicText, hermesPic,
                hestiaPicText, hestiaPic, dionysusPicText, dionysusPic);
        mainPane.getChildren().add(vBoxForGodPics);
        TabPane.getTabs().addAll(allGods, zeusTab, poseidonTab, heraTab, demeterTab, athenaTab, apolloTab, artmeisTab,
                aresTab, aphroditeTab, hephaestusTab, hermesTab, hestiaTab, dionysusTab);
    }
    public void textAndPaneForHeroes() {
        VBox vBoxForHeroes = new VBox(5);
        ScrollPane sp = new ScrollPane(vBoxForHeroes);
        ArrayList<String> heroesInfo = new ArrayList<>();

        heroesInfo.add("Son of Zeus and nemesis of the goddess Hera, Hercules was always too powerful for his foes.\n" +
                "He is perhaps best known for his fantastic feats of strength and daring, often called the \"12 Labors.\"\n" +
                "Some of these labors include slaying the nine-headed hydra, stealing the girdle of the Amazonian queen\n" +
                "Hippolyta, taming Cerberus, and slaying the Nemean lion. Hercules died after his wife, jealous that he\n" +
                "might have another lover, smeared a tunic with deadly centaur's blood, the pain of which drive Hercules\n" +
                "to kill himself. Hercules received the honor of being brought to live among the gods on Mount Olympus.\n\n");
        heroesInfo.add("Achilles was the Greeks' finest warrior during the Trojan War. His mother, the nymph Thetis, dipped\n" +
                "him in the River Styx to make him invulnerable in battle—except for his heel, where she gripped the baby.\n" +
                "During the Trojan War, Achilles achieved fame by slaying Hector outside the city gates. But he didn't have\n" +
                "much time to savor his conquest. Achilles died later in battle when an arrow shot by the Trojan prince Paris,\n" +
                "guided by the gods, struck the one vulnerable spot on his body: his heel.\n\n");
        heroesInfo.add("Theseus was the Athenian hero who liberated his city from the tyranny of King Minos of Crete. Every\n" +
                "year, the city had to send seven men and seven women to Crete to be devoured by the monstrous Minotaur.\n" +
                "Theseus vowed to defeat Minos and restore Athens' dignity. With the help of the creature's half-sister,\n" +
                "Ariadne, Theseus was able to enter the labyrinth where the monster lived, slay the beast, and find his way out again.\n\n");
        heroesInfo.add("A crafty and capable warrior, Odysseus was the king of Ithaca. His exploits in the Trojan War were\n" +
                "documented by Homer in the \"Iliad\" and further in the \"Odyssey,\" which chronicled Odysseus' 10-year\n" +
                "struggle to return home. During that time, Odysseus and his men faced numerous challenges, including being\n" +
                "kidnapped by a cyclops, menaced by sirens, and finally shipwrecked. Odysseus alone survives, only to face\n" +
                "additional tests before finally returning home.\n\n");
        heroesInfo.add("Perseus was the son of Zeus, who disguised himself as a shower of gold in order to impregnate Perseus'\n" +
                "mother Danae. As a young man, the gods helped Perseus to slay the snaky-tressed gorgon Medusa, who was so ugly\n" +
                "that she could turn to stone anyone who looked directly at her. After slaying Medusa, Perseus rescued Andromeda\n" +
                "from the sea serpent Cetus and wed her. He later gave the severed head of Medusa to the goddess Athena.\n\n");
        heroesInfo.add("Jason was born the son of the deposed king of Iolcos.\n" +
                "As a young man, he set out on a quest to find the Golden Fleece and thus restore his place on the throne.\n" +
                "He assembled a crew of heroes called the Argonauts and set sail.\n" +
                "He encountered a number of adventures along the way, including facing down harpies, dragons, and sirens.\n" +
                "Although he was ultimately triumphant, Jason's happiness didn't last long.\n" +
                "After he deserted her, his wife Medea murdered his children and he died sad and alone.\n\n");
        heroesInfo.add("Cadmus was the Phoenician founder of Thebes. After failing in his quest to find his sister Europa,\n" +
                "he wandered the land. During this time, he consulted the Oracle of Delphi, who ordered him to cease his\n" +
                "wanderings and settle in Boeotia. There, he lost his men to a dragon of Ares. Cadmus killed the dragon,\n" +
                "planted its teeth and watched as armed men (the Spartoi) emerged from the ground. They fought each other\n" +
                "down to a final five, who \u200Bhelped Cadmus found Thebes. Cadmus married Harmonia, daughter of Ares,\n" +
                "but suffered from guilt for having slain the war god's dragon. As repentance, Cadmus and his wife were\n" +
                "transformed into snakes.\n\n");
        heroesInfo.add("Although Greek heroes were overwhelmingly men, there's one woman that deserves a place in this list:\n" +
                "Atalanta. She grew up wild and free, able to hunt as well as a man. When an angry Artemis sent the Calydonian\n" +
                "Boar to ravage the land in revenge, Atalanta was the hunter who first pierced the beast. She is also said\n" +
                "to have sailed with Jason, the only female on the Argo. But she is perhaps best known for vowing to marry\n" +
                "the first man who could beat her in a footrace. Using three golden apples, Hippomenes was able to distract\n" +
                "the swift Atalanta and win the race—and her hand in marriage.\n\n");
        heroesInfo.add("Known more for his music than his fighting ability, Orpheus is a hero for two reasons. He was an\n" +
                "Argonaut in Jason's quest for the Golden Fleece, and he survived a quest that even Theseus failed.\n" +
                "Orpheus went to the Underworld to retrieve his wife, Eurydice, who had died of snakebite. He made his\n" +
                "way to the Underworld's royal couple—Hades and Persephone—and persuaded Hades to give him a chance to\n" +
                "bring his wife back to life. He got permission on condition that he did not look at Eurydice until they\n" +
                "reached the light of day, something he was unable to do.\n\n");
        heroesInfo.add("Bellerophon is known for his capturing and taming the wild winged stallion Pegasus, something said\n" +
                "to be impossible. With divine assistance, Bellerophon succeeded in riding the horse and set out to slay\n" +
                "the chimera that menaced Lycia. Having slain the beast, Bellerophon's fame grew until he became convinced\n" +
                "that he was not a mortal but a god. He tried to ride Pegasus to Mount Olympus, which so enraged Zeus that\n" +
                "he caused Bellerophon to fall to earth and die.\n\n");

        Text hercules = new Text("Hercules");
        Text herculesText = new Text(heroesInfo.get(0));
        hercules.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text achilles = new Text("Achilles");
        Text achillestext = new Text(heroesInfo.get(1));
        achilles.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text theseus = new Text("Theseus");
        Text theseusText = new Text(heroesInfo.get(2));
        theseus.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text odysseus = new Text("Odysseus");
        Text odysseusText = new Text(heroesInfo.get(3));
        odysseus.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text perseus = new Text("Perseus");
        Text perseusText = new Text(heroesInfo.get(4));
        perseus.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text jason = new Text("Jason");
        Text jasonText = new Text(heroesInfo.get(5));
        jason.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text cadmus = new Text("Cadmus");
        Text cadmusText = new Text(heroesInfo.get(6));
        cadmus.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text atalanta = new Text("Atalanta");
        Text atalantaText = new Text(heroesInfo.get(7));
        atalanta.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text orpheus = new Text("Orpheus");
        Text orpheusText = new Text(heroesInfo.get(8));
        orpheus.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text bellerophon = new Text("Bellerophon");
        Text bellerophonText = new Text(heroesInfo.get(9));
        bellerophon.setFont(Font.font("times new roman", FontWeight.BOLD, FontPosture.REGULAR, 20));

        vBoxForHeroes.getChildren().addAll(hercules, herculesText, achilles, achillestext, theseus, theseusText, odysseus, odysseusText,
                perseus, perseusText, jason, jasonText, cadmus, cadmusText, atalanta, atalantaText, orpheus, orpheusText, bellerophon, bellerophonText);
        vBoxForHeroes.setAlignment(Pos.TOP_LEFT);

        Tab heroesTab = new Tab("Heroes");
        heroesTab.setContent(sp);

        TabPane.getTabs().add(heroesTab);
    }

    }
