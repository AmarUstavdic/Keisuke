public class BusEvent {

    private EventType eventType;
    private GameMode gameMode;


    public BusEvent(EventType eventType, GameMode gameMode) {
        this.eventType = eventType;
        this.gameMode = gameMode;
    }

    public BusEvent(EventType eventType) {
        this.eventType = eventType;
        this.gameMode = null;
    }


    public EventType getEventType() {
        return eventType;
    }

    public GameMode getGameMode() {
        return gameMode;
    }
}
