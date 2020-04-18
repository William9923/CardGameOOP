package com.avatarduel.guicontroller.Card;

import com.avatarduel.event.*;
import com.avatarduel.guicontroller.RenderRequest.FieldRenderRequest;
import com.avatarduel.guicontroller.RenderRequest.GameStatusRenderRequest;
import com.avatarduel.guicontroller.RenderRequest.PlayerStatusRenderRequest;
import com.avatarduel.guicontroller.RenderRequest.CheckWinRequest;
import com.avatarduel.model.Game;
import com.avatarduel.model.card.CharacterCardInField;
import com.avatarduel.model.type.CharacterState;
import com.avatarduel.model.type.Phase;
import com.avatarduel.model.type.PlayerType;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

import java.util.List;

public class CharacterCardInFieldController extends CardInFieldController {
    @FXML ImageView card_rotate;
    @FXML ImageView card_attack;
    private CharacterCardInField characterCardInField;

    @FXML
    public void initialize() {
        card_actions.setVisible(false);
    }

    public void setCard(CharacterCardInField cardInField) {
        super.setCard(cardInField.getCard());
        this.characterCardInField = cardInField;
        super.card_atk.setText("ATK : " + characterCardInField.getTotalAttack());
        super.card_def.setText("DEF : " +  characterCardInField.getTotalDefense());
    }

    @FXML
    public void rotateCard() {
        IEvent event = new ChangePositionEvent(playerType, characterCardInField.getCard().getId());
        Game.getInstance().getEventBus().post(event);
        this.renderRotate();
    }

    public void renderRotate() {
        if(characterCardInField.getPosition() == CharacterState.DEFENSE) {
            card_border.rotateProperty().setValue(90);
            card_attack.setVisible(false);
        }
        else{
            card_border.rotateProperty().setValue(0);
            card_attack.setVisible(true);
        }
    }

    @FXML
    public void cardAttack() {
        if(Game.getInstance().getCurrentPhase().getPhase() != Phase.BATTLE) {
            Game.getInstance().getEventBus().post(new NextPhaseEvent());
            Game.getInstance().getEventBus().post(new GameStatusRenderRequest());
        }
        if (Game.getInstance().getPlayerByType(Game.getInstance().getCurrentOpponent()).getField().getCharCardList().size() == 0){
            Game.getInstance().getEventBus().post(new DirectAttackEvent(this.getCardData().getId(), playerType));
            Game.getInstance().getEventBus().post(new PlayerStatusRenderRequest(Game.getInstance().getCurrentOpponent()));
        }
        else if (Game.getInstance().getPlayerByType(Game.getInstance().getCurrentOpponent()).getField().getCharCardList().size() > 0) {
            List<CharacterCardInField> opponentField = Game.getInstance().getPlayerByType(Game.getInstance().getCurrentOpponent()).getField().getCharCardList();
            ChoiceDialog<CharacterCardInField> choiceAttack = new ChoiceDialog<>(opponentField.get(0), opponentField);
            ChoiceBox<CharacterCardInField> choiceBox = new ChoiceBox<CharacterCardInField>();

            choiceBox.setItems(new ObservableListWrapper<>(opponentField));
            VBox popupContainer = new VBox();
            HBox popupActions = new HBox();
            Button attack = new Button("Attack");
            Button cancel = new Button("Cancel");
            popupActions.getChildren().addAll(attack, cancel);
            popupContainer.getChildren().addAll(choiceBox, popupActions);
            Popup popup = new Popup();
            popup.setHeight(200);
            popup.setWidth(200);
            popup.getContent().addAll(popupContainer);
            popup.show(card_rotate.getScene().getWindow());
            attack.setOnAction(e -> {
                if (choiceBox.getSelectionModel().getSelectedItem() != null) {
                    IEvent event = new AttackEvent(this.getCardData().getId(), choiceAttack.getSelectedItem().getCard().getId(), Game.getInstance().getCurrentPlayer(), Game.getInstance().getCurrentOpponent());
                    Game.getInstance().getEventBus().post(event);
                    Game.getInstance().getEventBus().post(new PlayerStatusRenderRequest(Game.getInstance().getCurrentOpponent()));
                    Game.getInstance().getEventBus().post(new FieldRenderRequest(Game.getInstance().getCurrentOpponent()));
                    Game.getInstance().getEventBus().post(new FieldRenderRequest(Game.getInstance().getCurrentPlayer()));
                }
                popup.hide();
            });
            cancel.setOnAction(event -> popup.hide());

//            choiceAttack.showAndWait();
//            if (choiceAttack.getSelectedItem() != null) {
//                IEvent event = new AttackEvent(this.getCardData().getId(), choiceAttack.getSelectedItem().getCard().getId(), Game.getInstance().getCurrentPlayer(), Game.getInstance().getCurrentOpponent());
//                Game.getInstance().getEventBus().post(event);
//                Game.getInstance().getEventBus().post(new PlayerStatusRenderRequest(Game.getInstance().getCurrentOpponent()));
//                Game.getInstance().getEventBus().post(new FieldRenderRequest(Game.getInstance().getCurrentOpponent()));
//                Game.getInstance().getEventBus().post(new FieldRenderRequest(Game.getInstance().getCurrentPlayer()));
//            }
        }
        Game.getInstance().getEventBus().post(new CheckWinRequest());
        Game.getInstance().getEventBus().post(this.characterCardInField);
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
