package ro.nila.business;

public enum ElementsState {
    DISPLAYED("isDisplayed"), HIDDEN("isHidden"), ENABLED("isEnabled"), DISABLED("isDisabled"), SELECTED("isSelected"), DESELECTED("isDeselected");

    private String state;

    ElementsState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getOppositeState() {
        switch (this) {
            case DISPLAYED:
                return HIDDEN.getState();
            case HIDDEN:
                return DISABLED.getState();
            case ENABLED:
                return DISABLED.getState();
            case DISABLED:
                return ENABLED.getState();
            case SELECTED:
                return DESELECTED.getState();
            case DESELECTED:
                return SELECTED.getState();
            default:
                return null;
        }
    }
}
