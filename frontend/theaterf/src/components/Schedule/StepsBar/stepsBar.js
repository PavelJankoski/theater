import React from "react";

const StepsBar = () =>{
    return(
        <div className="steps">
            <ul className="steps-container">
                <li style={{width:'33%'}} className="activated">
                    <div className="step">
                        <div className="step-image"><span></span></div>
                        <div className="step-current">Select Show</div>
                    </div>
                </li>
                <li style={{width:'33%'}}>
                    <div className="step">
                        <div className="step-image"><span></span></div>
                        <div className="step-current">Select Seats</div>
                    </div>
                </li>
                <li style={{width:'33%'}}>
                    <div className="step">
                        <div className="step-image"><span></span></div>
                        <div className="step-current">Confirmation</div>
                    </div>
                </li>
            </ul>
            <div className="step-bar" style={{width: '33%'}}></div>
        </div>
    );
}
export default StepsBar;