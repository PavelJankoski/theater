import React from "react";

const StepsBar = (props) =>{



    return(
        <div className="steps">
            <ul className="steps-container">
                <li style={{width:'33%'}} className="activated">

                </li>
                <li style={{width:'33%'}}>

                </li>
                <li style={{width:'33%'}}>
                    <div className="step">
                        <div className="step-image"><span></span></div>
                        <div className="step-current">Confirmation</div>
                    </div>
                </li>
            </ul>
            <div className="step-bar" style={props.widthPercentage}></div>
        </div>
    );
}
export default StepsBar;