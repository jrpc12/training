import React, {useState} from "react"

export const Minesquare = (props) => {

    const[posi, setPosi] = useState(props.posi);
    const[posj, setPosj] = useState(props.posj);

    return(
    <div className={props.cardState.isOpened? "mine-opened": "mine-closed"} onClick={ ()=> props.updateCard(posi,posj) }>
        {props.cardState.isOpened? props.cardState.hasBomb? "X" : (props.cardState.bombsAround > 0? props.cardState.bombsAround : "") : ""}
    </div>
    )

}