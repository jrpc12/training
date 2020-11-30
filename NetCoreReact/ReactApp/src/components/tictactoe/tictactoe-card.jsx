import React, {useState} from "react"

export const TicTacToeCard = (props) =>{


  
  function updateCardValue(player){

      if(props.cardValue === ""){
        props.updateCardValue(player, props.posi, props.posj);
      }
      
    
    }

  return (
      <div className="tictactoe-card" onClick={ () => updateCardValue(props.player)  }>
        {props.cardValue}
      </div>
  )

}