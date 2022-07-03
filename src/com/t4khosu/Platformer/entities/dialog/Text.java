package com.t4khosu.Platformer.entities.dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import com.t4khosu.Platformer.Game;

public class Text {

    private final String text;
    private final Dialogbox db;

    private int posX;
    private int posY;
    private Color headlineColor = new Color(180, 240, 180);
    private Font headlineFont = new Font("Arial Hebrew", Font.BOLD, 14);
    private Color textColor = Color.white;
    private Font textFont = new Font("Arial Hebrew", Font.PLAIN, 14);

    private String shortText = "";
    private String formattedShortText = "";
    private int textShown = 0;
    private boolean skippable = true;

    private boolean multiChoice = false;
    private String[] choices;


    /**
     * constructor, text and dialogbox written in
     */
    public Text(String text, Dialogbox db) {
        this.text = text;
        this.db = db;
		this.textShown = 0;

        this.posX = Game.width * Game.scale / 2 - 160;
        this.posY = Game.height * Game.scale / 2 - 210;
    }

    /**
     * Update text by making it longer. The smaller speed is, the faster the text will change
     */
    public void update() {
        final int textSpeed = 2;

        if (Game.timer % textSpeed == 0) {
            if (this.textShown < this.text.length()){
				this.textShown++;
			}

			int start = this.db instanceof NPCDialogbox || this.db instanceof MultiChoiceDialog ? 1 : 0;
			this.shortText = this.text.substring(start, this.textShown);
			this.formattedShortText = this.formatUmlauts(this.shortText);
        }
    }

    /**
     * First render headline and then in a for-loop all the dialog parts
     */
    public void renderText(Graphics g) {
        g.setColor(this.headlineColor);
        g.setFont(this.headlineFont);

        if (db.getWaitTimer() == 0) {
            g.drawString(db.getHeadline(), this.posX, this.posY);
        }

        g.setColor(this.textColor);
        g.setFont(this.textFont);

        ArrayList<String> text = stringSplit(g, 270, this.formattedShortText);
        for (int i = 0; i < text.size(); i++) {
            g.drawString(text.get(i), this.posX, this.posY + 22 * (i + 1));
        }

        if (multiChoice && this.textShown == this.text.length()) {
            for (int i = 0; i < choices.length; i++) {
                String arrow = i == db.getSelectedChoice() ? "\u21E8 " : " ";
                g.drawString(arrow + choices[i], this.posX, this.posY + 22 * (text.size() + i + 1));
            }
        }
    }

    /**
     * Split text into matching lines (length = maxSize) for a dialog box
     */
    public ArrayList<String> stringSplit(Graphics g, int maxSize, String dialog) {
        ArrayList<String> split = new ArrayList<>();
        String[] splitted = dialog.split(" ");

        String add = "";
        for (String s : splitted) {
            add += s + " ";
            int width = g.getFontMetrics().stringWidth(add);
            if (width > maxSize) {
                split.add(add);
                add = "";
            }
        }
        split.add(add);
        return split;
    }

    /**
     * finish text when can skip
     */
    public void finishText() {
        this.textShown = this.skippable ? this.text.length() : this.textShown;
    }

	private String formatUmlauts(String input){
		return input
				.replaceAll("ü", "\u00FC")
                .replaceAll("ä", "\u00E4")
                .replaceAll("ö", "\u00F6")
                .replaceAll("Ü", "\u00DC")
                .replaceAll("Ä", "\u00C4")
                .replaceAll("Ö", "\u00D6")
                .replaceAll("ß", "\u00df");
	}


    public void setMultiChoice(boolean multiChoice) {
        this.multiChoice = multiChoice;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public String getText() {
        return text;
    }

    public String getShortText() {
        return shortText;
    }

    public boolean getMultiChoice() {
        return multiChoice;
    }
}