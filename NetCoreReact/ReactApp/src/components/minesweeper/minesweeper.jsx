import React, {useState, useReducer} from "react";
import {Minesquare} from "./mine-square.jsx";

export const Minesweeper = () => {

    const boardsize = 10;
    const totalBombs = 10;
    class cardState  {
        isOpened = false;
        hasBomb = false;
        bombsAround = 0;
    }

    const[unk, forceUpdate] = useReducer( x => x+1, 0)
    const [board, setBoard] = useState( () => initBoard() );
    const [gameOver, setGameOver] = useState(false);
    
    function initBoard(){

        let newboard = [];

        for(let i=0; i< boardsize; i++){
            newboard[i] = [];
            for(let j=0; j< boardsize; j++){
                newboard[i][j] = new cardState();
            }
        }

        fillBombs(newboard,totalBombs);
        fillNumbers(newboard);

        return newboard;
    }

    function fillBombs(newboard,totalbombs){

        while(totalbombs > 0){
            let i= Math.floor(Math.random() * boardsize);
            let j= Math.floor(Math.random() * boardsize);
            newboard[i][j].hasBomb = true;
            totalbombs--;
        }
    }

    
    function fillNumbers(newboard){

        for(let i=0; i< newboard.length; i++){
            for(let j=0; j<newboard.length; j++){
                if(newboard[i][j].hasBomb){

                    for(let x=i-1; x<=i+1; x++ ){
                        for(let y=j-1; y<=j+1; y++){
                            if( (i==x && j==y) || !positionExits(newboard, x,y) ){
                                continue;
                            }else{
                                newboard[x][y].bombsAround += 1;
                            }
                        }
                    }


                }
            }
        }
    }


    function openBlankCard(newboard,i,j){

        if(!newboard[i][j].isOpened){

            newboard[i][j].isOpened = true;

        
            for(let x=i-1; x<=i+1; x++ ){
                for(let y=j-1; y<=j+1; y++){

                    if( (i==x && j==y) || !positionExits(newboard, x,y) ){
                        continue;
                    }else{
                        openBlankCard(newboard,x,y);
                    }
                }
            }
        } 
        
        return newboard;
    }


    function positionExits(newboard,i,j){

        return  (i >= 0 && i < newboard.length) && (j >=0 && j < newboard.length)

    }
    
    function onClickCard(i,j){

        let newboard = board;
        if(!gameOver){

            newboard[i][j].isOpened = true;

            if(newboard[i][j].hasBomb){
                setGameOver(true);
            }else if(newboard[i][j].bombsAround == 0){
                newboard = openBlankCard(newboard,i,j);
            }
            setBoard(newboard);
            forceUpdate();
        }

    }

    return(
        <table>
            <tbody>
                {board.map((row,i) => {
                    return <tr key={i}>
                        {row.map((col,j) =>{
                            return <td key={j}>
                                <Minesquare posi={i} posj={j} cardState={col} updateCard={onClickCard} />
                            </td>
                        })}
                    </tr>

                })}
            </tbody>
        </table>
    )

}