package sample;

/**
 * ItemType allows the choice box to be populated with four different codes to determine what type
 * of product is being inserted into the database.
 */
public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  public final String codes;

  /**
   * This sets codes to code. This helps with when you are populating the database.
   *
   * @param code is the abbreviation used for the different types.
   */
  ItemType(String code) {
    codes = code;
  }

  /**
   * getCodes allows the controller to pull the information from ItemType and put it into the
   * database.
   *
   * @return codes - this makes sure the item type gets populated.
   */
  public String getCodes() {
    return this.codes;
  }
}
