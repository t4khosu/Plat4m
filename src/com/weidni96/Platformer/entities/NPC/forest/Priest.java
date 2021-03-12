package com.weidni96.Platformer.entities.NPC.forest;

import com.weidni96.Platformer.Level.Level;
import com.weidni96.Platformer.entities.NPC.Choices;
import com.weidni96.Platformer.entities.NPC.NPC;
import com.weidni96.Platformer.graphics.Screen;

public class Priest extends NPC {

    /**
     * constructor
     *
     * @param x
     * @param y
     * @param sprite
     * @param level
     * @param walker
     * @param name
     * @param actionChange
     * @param basis
     */
    public Priest(int x, int y, Level level) {
        super(x, y, null, level, true, "Priester", 50, 200);
    }

    /**
     * generate all dialogs
     */
    public void generateDialogs() {
        actualDialog = 0;

        String[] ch = {"Ja, bitte.", "Kein Interesse..."};
        choices.add(new Choices(0, ch));

        String[] a = {"#Die Welt hat gek\u00E4mpft gegen sich selbst und verloren.",
                "#Wir waren im Kampfe verwickelt, ob wir nun wollten oder nicht.",
                "#Wir haben getan was wir konnten, doch genommen wurde uns fast alles.",
                "#Unser Dorf geschrumpft, die alte Stadt ist dahin.",
                "#Ich bete f\u00FCr all die Toten.",
                "#......",
                "#Ob nun unsere oder deren. Mensch ist Mensch.",
                "#M\u00F6ge die Welt wieder ins Reine kommen, auf dass wir alle in Frieden leben k\u00F6nnen.",
                "#...",
                "#Du bist neu hier, habe ich recht?",
                "#Du magst zwar ein Fremdling sein, doch scheinst du mir von friedlicher Natur zu sein.",
                "#Sag mir, wei\u00dft du wovon ich gerade gesprochen habe?",
                "#...",
                "#Nein?! ... Es scheint dass in anderen Gegenden viel daf\u00FCr getan wird, manches zu verschweigen.",
                "#Magst du wissen wo genau du hier bist?"};
        dialogs.add(a);

        String[] b = {"#Du bist hier in NEULEBEN!",
                "#Ein kleines, junges Dorf das gerade einmal 78 Jahre alt ist.",
                "#Ja, du hast richtig geh\u00F6rt, wir sind keine Uralte Siedlung...",
                "#Vielmehr sind wir eine neu aufgebaute Gemeinschaft.",
                "#Mein Opa, auch ein Prister, erz\u00E4hlte mir die Geschichte von Damals.",
                "#Hier, wo du gerade stehst, stand einst eine gigantische Kathetrale...",
                "#Davor ein Marktplatz an dem t\u00E4glich hunderte Menschen handel betrieben...",
                "#In Zeiten der Technologie mag es f\u00FCr dich absurd klingen, doch als man vor 500 Jahren die TRENNUNG vornahm,",
                "#Hat sich eine Randgruppe gebildet, die nicht nur hier blieb, sondern auch ein primitiveres Leben hegen wollte...",
                "#So bildete sich vor 300 Jahren BELLMARE... eine Stadt die innerhalb weniger Jahre aufbl\u00FChte.",
                "#... Nur was ist von dieser Stadt geblieben *schluchz*",
                "#Nur Bilder zeugen von der damaligen Sch\u00F6nheit dieser Stadt...",
                "#......",
                "#..........",
                "#Vor 79 Jahren...",
                "#Ist es geschehen...",
                "#Mit Bomben wurde nach uns vom Himmel geworfen.",
                "#Es schien als h\u00E4tte Gott \u00FCber uns richten wollen...",
                "#Aber so war es nicht...",
                "#Die Fliegende Stadt hat uns beschossen, so sagte es mein Opa.",
                "#Wieso... kann ich nicht sagen... wer wei\u00df...",
                "#Es soll katastrophal gewesen sein mit hunderten Toten...",
                "#Jedoch haben ein paar \u00FCberlebt und im folgenden Jahr eine kleine Siedlung von nicht mehr als 20 Personen aufgebaut haben...",
                "#Neuleben...",
                "#Seit dem leben wir hier in Frieden... Doch noch immer mit der Angst, dass auch wir bald ausgel\u00F6scht werden k\u00F6nnen.",
                "#............",
                "#puh......",
                "#Entschuldige, die Geschichte zerrt immer sehr an meinen Kr\u00E4ften...",
                "#Wenn du mehr erfahren willst, lies doch ein paar B\u00FCcher dieser Gegend.",
                "#Du vertr\u00E4gst dieses Thema sicher besser als ich... Amen"};
        dialogs.add(b);

        String[] c = {"#Jedem das seine...",
                "#Ich w\u00FCnsche dir noch viel Erfolg auf deinen Wegen.",
                "#Amen."};
        dialogs.add(c);
    }

    /**
     * check when npc stops talking
     */
    public void stopTalking() {
        talking = false;

        if (actualDialog == 0) {
            if (choices.get(0).getSelectedChoice() == 0) { //explain
                actualDialog += 1;
            } else { //not explain
                actualDialog += 2;
            }
        } else if (actualDialog == 1 || actualDialog == 2) {
            actualDialog = 0;
        }


    }

    /**
     * check when npc starts talking
     */
    public void talk() {
        talking = true;
    }

    /**
     * render sprite
     *
     * @param screen
     */
    public void render(Screen screen) {
        screen.renderNewHSB(x, y, sprite, true, 0.15f, 0.8f);
    }
}
