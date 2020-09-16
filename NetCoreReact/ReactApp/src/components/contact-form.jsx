import React from "react";

export class RegisterForm extends React.Component{

    constructor(){
        super();
        this.myDivRef = React.createRef(); 
    }

    componentDidMount(){
        this.myDivRef.current.innerHTML = "<strong><i> Injected by REf!</i></strong>";
    }

    render() {
        return(
            <>
            <h2>Fill contact information:</h2>
            <div dangerouslySetInnerHTML={{__html:"<strong><i> Injected</i> </strong>"}}></div>
            <div ref={this.myDivRef}></div>
            </>
        )
    }
}