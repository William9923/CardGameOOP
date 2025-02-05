package com.avatarduel.event;

import com.avatarduel.exception.ExceptionCause.InvalidPhaseCause;
import com.avatarduel.exception.ExceptionCause.MultipleLandCardPlayedOnTheSameTurnCause;
import com.avatarduel.exception.InvalidPlayLandCardException;
import com.avatarduel.exception.InvalidOperationException;
import com.avatarduel.model.Game;
import com.avatarduel.model.card.LandCard;
import com.avatarduel.model.player_component.Player;
import com.avatarduel.model.type.CardType;
import com.avatarduel.model.type.Phase;
import com.avatarduel.model.type.PlayerType;

/**
 * PlayLandCardEvent is a event for activating land card.
 *
 * IMPORTANT NOTE:
 * This event will communicate with game singleton instantly, so there are no need to validate
 * In case where event is not possible to do, we throw exception so that the GUI Board can give the
 * error message to the player playing the games
 * @author G10-K03-CardGameOOP
 */

public class PlayLandCardEvent implements IEvent {
    private PlayerType playerType;
    private int landCardID;

    public PlayLandCardEvent(int idCard, PlayerType playerType) {
        this.playerType = playerType;
        this.landCardID = idCard;
    }

    /**
     * execute method to run the event invoked by user action
     */
    @Override
    public void execute() throws InvalidOperationException {
        LandCard landCard = (LandCard) Game.getInstance().getPlayerByType(playerType).getHand().stream()
                .filter(card -> card.getId() == landCardID && card.getType().equals(CardType.LAND))
                .findFirst()
                .orElse(null);
        Phase currPhase = Game.getInstance().getCurrentPhase().getPhase();
        PlayerType currPlayer = Game.getInstance().getCurrentPlayer();
        int currentFieldSize = Game.getInstance().getPlayerByType(playerType).getField().getSkillCardList().size();

        if (currPhase != Phase.MAIN) {
            throw new InvalidPlayLandCardException(new InvalidPhaseCause(Phase.MAIN));
        }

        if (Game.getInstance().getPlayerByType(currPlayer).hasPlayLand) {
            throw new InvalidPlayLandCardException(new MultipleLandCardPlayedOnTheSameTurnCause());
        }

        Player player = Game.getInstance().getPlayerByType(playerType);
        // remove card
        player.getHand().remove(landCard);
        // add power to player
        player.getPower().add(landCard.getElement(),1);
        // change state of hasPlayLand of player
        player.hasPlayLand = true;
    }

}
