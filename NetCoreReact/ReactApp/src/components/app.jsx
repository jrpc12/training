import React from "react";
import { BrowserRouter, Route } from 'react-router-dom';
import { SprintRelease } from "./jira/sprint-release.jsx"
import {RegisterForm} from "./contact-form.jsx";

export class App extends React.Component{

    constructor(){
        super();
    }

    render(){
        return(
            <BrowserRouter>
                <React.Fragment>
                    <Route exact path="/" component={SprintRelease}/>
                    <Route exact path="/register" component={RegisterForm}/>
                </React.Fragment>
            </BrowserRouter>
        )
    }

}