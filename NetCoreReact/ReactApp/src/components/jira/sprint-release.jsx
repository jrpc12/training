import React from "react";

export class SprintRelease extends React.Component{

    /*
    state = { 
        jiracards : ["AA-3937"]
    };
    */
    constructor(props) {
        super(props);        
        
        this.state = { 
            jiracards : ["AA-3937"]
        };

        //this.updateFixVersion = this.updateFixVersion.bind(this);
    } 

    updateFixVersion = () => {
    //updateFixVersion() {

        console.log( this.state.jiracards);

         fetch("https://localhost:44313/JiraApi/", {
            method: 'POST',
            mode: 'cors',
            headers: {                
                "Content-Type":"application/json"
              },
            body: JSON.stringify( this.state.jiracards),
        })
        //.then(response => {response.json()})
        .then(response => {
                console.log(response.json());
                this.setState({jiracards : []});
            }       
        ).catch(error => {
            alert(error);
         });
        
    }

    componentDidMount(){
        //router default props: match
        console.log("match",this.props.match);
    }

    render(){
        return(
            <div>
                <h3>Add current done ticket to sprint release version</h3>
                <button onClick={ this.updateFixVersion} >Run</button>
            </div>
        );
    }
}