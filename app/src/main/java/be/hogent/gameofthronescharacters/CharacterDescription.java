package be.hogent.gameofthronescharacters;

/**
 * Created by Jens Buysse on 2/11/2015.
 */
public class CharacterDescription {

    /**
     * The image
     */
    private int image;

    /**
     * Name of the character
     */
    private String characterName;

    /**
     * The description of the character
     */
    private String description;

    /**
     * Constructor
     * @param image 
     * @param characterName
     * @param description
     */
    public CharacterDescription(int image, String characterName, String description) {
        this.image = image;
        this.characterName = characterName;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
