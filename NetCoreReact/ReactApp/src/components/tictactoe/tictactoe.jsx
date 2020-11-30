import React, {useEffect, useState} from "react"
import { TicTacToeCard } from "./tictactoe-card.jsx";

export const TicTacToe = () => {

    const [cardValues,setCardValues] = useState([["","",""],["","",""],["","",""]]);
    const [currentPlayer, setCurrentPlayer] = useState("X");
    const [winner, setWinner] = useState("");
    const [ gameOver, setGameOver] = useState(false);

    function updateCardValue(val,posi,posj){

        let copyCardValue = cardValues.slice();

        copyCardValue[posi][posj] = val;;
        setCardValues(copyCardValue);
        togglePlayer();
        validateWinner();

    }

    function togglePlayer(){
        setCurrentPlayer( (currentPlayer === "X")? "O" : "X");
    }

    function endGame(winner){
        setWinner(winner);
        setGameOver(true);

    }

    function resetGame(evt){
        evt.preventDefault();
        setCardValues([["","",""],["","",""],["","",""]]);
        setCurrentPlayer("X");
        setGameOver(false);
    }

    function validateWinner(){

        let thereIsWinner = false;
        let playerValue = "";

        //Row verification
        for(let i=0; i<cardValues.length; i++){

            playerValue = cardValues[i][0];
            if(!playerValue){
                continue;
            }

            for(let j=1; j<cardValues[i].length; j++){
                if(playerValue === cardValues[i][j]){
                    thereIsWinner = true;
                    continue;
                }
                else{
                    thereIsWinner = false;
                    break;
                }
            }

            if(thereIsWinner){
                endGame(playerValue);
                break;
            }
        }


        //Column verification
        for(let jj=0; jj<cardValues.length; jj++){

            playerValue = cardValues[0][jj];
            if(!playerValue){
                continue;
            }

            for(let ii=1; ii<cardValues[jj].length; ii++){
                if(playerValue === cardValues[ii][jj]){
                    thereIsWinner = true;
                    continue;
                }
                else{
                    thereIsWinner = false;
                    break;
                }
            }

            if(thereIsWinner){
                endGame(playerValue);
                break;
            }
        }


        //Diagonal verification
        for(let jj=0; jj<cardValues.length; jj++){

            playerValue = cardValues[0][jj];
            if(!playerValue){
                continue;
            }

            for(let ii=1; ii<cardValues[jj].length; ii++){
                if(playerValue === cardValues[ii][jj]){
                    thereIsWinner = true;
                    continue;
                }
                else{
                    thereIsWinner = false;
                    break;
                }
            }

            if(thereIsWinner){
                endGame(playerValue);
                break;
            }
        }


        //left-right diagonal
        playerValue = cardValues[0][0];
        if(playerValue){
            for(let i=1; i<cardValues.length; i++){
                if(playerValue === cardValues[i][i]){
                    thereIsWinner = true;
                    continue;
                }
                else{
                    thereIsWinner = false;
                    break;
                }
            }

            if(thereIsWinner){
                endGame(playerValue);
            }
        }


        //right-left diagonal
        let maxlen = cardValues.length-1;
        playerValue = cardValues[0][maxlen];
        if(playerValue){
            for(let i=1; i < cardValues.length; i++){
                if(playerValue === cardValues[i][--maxlen]){
                    thereIsWinner = true;
                    continue;
                }
                else{
                    thereIsWinner = false;
                    break;
                }
            }
            if(thereIsWinner){
                endGame(playerValue);
            }
        }  
           

    }

    return(
        <div className="tictactoe-container">
        <table>
            <tbody>
            { cardValues.map( (row,i) => {
                return (
                <tr key={i}>
                    {row.map( (val,j) => { 
                        return <td key={j}>
                                <TicTacToeCard player={currentPlayer} cardValue={val} updateCardValue={updateCardValue} posi={i} posj={j}  />
                            </td> 
                    })}
                </tr>
                )
                
            })}
            </tbody>
        </table>

        <button className="reset" onClick={ (evt) => resetGame(evt) }>Reset</button>
        {gameOver? <div className="winner">The winner is  {winner} </div> : null}
        
        </div>
        
    )


}