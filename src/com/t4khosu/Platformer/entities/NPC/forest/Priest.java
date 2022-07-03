package com.t4khosu.Platformer.entities.NPC.forest;

import com.t4khosu.Platformer.Level.Level;
import com.t4khosu.Platformer.entities.NPC.Choices;
import com.t4khosu.Platformer.entities.NPC.NPC;
import com.t4khosu.Platformer.graphics.Screen;

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

        String[] a = {"#Die Welt hat gekämpft gegen sich selbst und verloren.",
                "#Wir waren im Kampfe verwickelt, ob wir nun wollten oder nicht.",
                "#Wir haben getan was wir konnten, doch genommen wurde uns fast alles.",
                "#Unser Dorf geschrumpft, die alte Stadt ist dahin.",
                "#Ich bete für all die Toten.",
                "#......",
                "#Ob nun unsere oder deren. Mensch ist Mensch.",
                "#Möge die Welt wieder ins Reine kommen, auf dass wir alle in Frieden leben können.",
                "#...",
                "#Du bist neu hier, habe ich recht?",
                "#Du magst zwar ein Fremdling sein, doch scheinst du mir von friedlicher Natur.",
                "#Sag mir, weißt du wovon ich gerade gesprochen habe?",
                "#...",
                "#Nein?! ... Es scheint dass in anderen Gegenden viel dafür getan wird, manches zu verschweigen.",
                "#Magst du wissen wo genau du hier bist?"};
        dialogs.add(a);

        String[] b = {"#Du bist hier in Neuleben!",
                "#Ein junges Dorf das gerade einmal 78 Jahre alt ist.",
                "#Ja, du hast richtig gehört, wir sind keine uralte Siedlung...",
                "#Vielmehr sind wir eine neu aufgebaute Gemeinschaft.",
                "#Mein Opa, auch ein Priester, erzählte mir die Geschichte von damals.",
                "#Hier, wo du gerade stehst, stand einst eine gigantische Kathedrale...",
                "#Daneben ein Marktplatz, an dem täglich hunderte Menschen handel betrieben.",
                "#In Zeiten der Technologie mag es für dich absurd klingen, doch als man vor 500 Jahren die Große Trennung vornahm,",
                "#Hat sich eine Randgruppe gebildet, die nicht nur hier blieb, sondern auch ein primitiveres Leben hegen wollte.",
                "#So bildete sich vor 300 Jahren Bellmare, eine Stadt die innerhalb weniger Jahre aufblühte.",
                "#... Nur was ist von dieser Stadt geblieben *schluchz*",
                "#Nur Bilder zeugen von der damaligen Schönheit Bellmares...",
                "#......",
                "#..........",
                "#Vor 79 Jahren...",
                "#Ist es geschehen...",
                "#Sprengkörper fielen vom Himmel.",
                "#Es schien, als hätte Gott über uns richten wollen.",
                "#Aber so war es nicht.",
                "#Die Fliegende Stadt hat uns beschossen, so sagte es mein Opa.",
                "#Wieso? Das kann ich nicht sagen. Wer weiß das schon...",
                "#Es soll katastrophal gewesen sein.",
                "#Jedoch haben ein paar Menschen überlebt und im folgenden Jahr eine kleine Siedlung von nicht mehr als 20 Personen aufgebaut.",
                "#Neuleben.",
                "#Seitdem leben wir hier in Frieden, doch noch immer mit der Angst, dass auch wir bald ausgelöscht werden können.",
                "#............",
                "#puh......",
                "#Entschuldige, die Geschichte zehrt immer an meinen Kräften...",
                "#Wenn du mehr erfahren willst, lies doch ein paar Bücher.",
                "#Du verträgst dieses Thema sicher besser als ich... Amen"};
        dialogs.add(b);

        String[] c = {"#Jedem das seine...",
                "#Ich wünsche dir noch viel Erfolg auf deinen Wegen.",
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
