import React from "react";
import { BrowserRouter, Route } from 'react-router-dom';
import { Home } from "./home.jsx"
import { RegisterForm } from "./contact-form.jsx";
import { About } from "./about.jsx"
import { TicTacToe } from "./tictactoe/tictactoe.jsx";

export class App extends React.Component{

    constructor(){
        super();
    }

    render(){
        return(
            <BrowserRouter>
                <React.Fragment>
                    <Route exact path="/" component={Home}/>
                    <Route exact path="/register" component={RegisterForm}/>
                    <Route exact path="/about" component={About}/>
                    <Route exact path="/tictactoe" component={TicTacToe}/>
                </React.Fragment>
            </BrowserRouter>
        )
    }

}