import React, {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import axios from 'axios';
import Moment from "react-moment";
import AvailableSeat from '../../../images/available-seat.png';
import SelectedSeat from  '../../../images/selected-seat.png';
import TakenSeat from '../../../images/taken-seat.png';
import StepsBar from "../../Schedule/StepsBar/stepsBar";

const ListSeats = ()=>{

    const {showId} = useParams();
    const [seats, setSeats] = useState([]);
    const [showSceneName, setShowSceneName] = useState({});



    useEffect(()=>{
        document.title = "Theater | Seats";
        axios.get("http://localhost:8080/shows/" + showId).then((resp) =>{

            let redovi;
            if(resp.data.scene.capacity%resp.data.scene.seatsInRow === 0){
                redovi = resp.data.scene.capacity/resp.data.scene.seatsInRow;
            }
            else{
                redovi = Math.floor(resp.data.scene.capacity/resp.data.scene.seatsInRow) + 1;
            }
            let cnt = 0;
            let vkupno =[];
            for(let i = 0 ;i<redovi;i++){
                let edenRed = [];
                debugger;
                for(let j = 0 ;j<resp.data.scene.seatsInRow;j++){

                    edenRed.push(resp.data.scene.seats[cnt]);
                    cnt++;
                    if(cnt===resp.data.scene.seats.length){
                        break;
                    }
                }

                vkupno.push(edenRed);

            }
            setSeats(vkupno);
            setShowSceneName({showName:resp.data.title, showDate:resp.data.from, sceneName:resp.data.scene.name});


        })
    }, [])


    const changeSeat = (e) =>{
        // e.target.src='../../../images/selected-seat.png'
        e.target.style.cursor ='pointer';
    }




    return(
        <div className="bcg" style={{paddingBottom: '50px'}}>

            <div className="steps">
                <ul className="steps-container">
                    <li style={{width:'33%'}} className="activated">
                        <div className="step">
                            <div className="step-image">
                                <div className="complited"><span></span></div>
                            </div>
                            <div className="step-current">Select Show</div>
                        </div>
                    </li>
                    <li style={{width:'33%'}} className="activated">
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
                <div className="step-bar" style={{width:'66%'}}></div>
            </div>

            <div className="row flex-row justify-content-center m-0">
                <div
                    style={{textAlign: 'center', paddingBottom: '30px'}}>
                    <h2 className="naslov">
                        Select seats for {showSceneName.showName}</h2>
                </div>
            </div>

            <div className="p-4 container" style={{backgroundColor: '#f2f3f4', borderRadius: '.50rem', color: '#444444'}}>
                <div style={{borderWidth: '0 0 1px 0', borderStyle: 'solid', borderColor: '#444444', marginBottom: '40px'}}>
                    <div className="row" style={{fontSize: '17px'}}>
                        <div className="col-4">
                            <span>{showSceneName.sceneName}</span>
                        </div>
                        <div className="col-8 ml-auto" style={{textAlign: 'end', whiteSpace: 'nowrap'}}>
                         <Moment format="dddd, DD MMMM YYYY - HH:mm">
                                {showSceneName.showDate}
                            </Moment>h
                        </div>

                    </div>
                </div>
                <div className="p-3" style={{marginBottom: '20px'}}>
                    <div className="row">
                        <div className="col-2"></div>
                        <div className="col-10 d-table"
                             style={{height: "50px", borderBottomLeftRadius: '25px', borderBottomRightRadius: '25px', textAlign: 'center', borderWidth: '0 2px 2px 2px', borderStyle: 'solid', borderColor: '#444444'}}>
                            <h3 className="d-table-cell align-middle" style={{textTransform: 'uppercase'}}>Scene</h3>
                        </div>
                    </div>
                </div>

                <div className="seats">
                    {seats.map((row, i) => (
                            <div className="p-3" key={i}>
                                <div className="row">
                                    <div className="col-2 pt-2 pb-2 d-table" style={{textAlign: 'center'}}>
                                        <span className="d-table-cell align-middle" style={{fontWeight:'bold'}}>{i + 1}</span>
                                    </div>
                                    <div className="col-10 text-center">

                                        {
                                            row.map((col, i) => (
                                                <img key={col.id} onMouseOver={changeSeat} className="img-fluid available px-1" src={AvailableSeat}
                                                     style={{transform: 'rotate(180deg)', maxWidth: '7%'}}/>
                                            ))
                                        }

                                    </div>
                                </div>
                            </div>
                        )
                    )
                    }


                    <div className="legend row" style={{marginTop: '60px'}}>
                        <div className="col-4 text-center">
                            <img className="img-fluid" src={AvailableSeat}
                                 style={{transform: 'rotate(180deg)', maxWidth: '15%'}}/>
                                <span> - Available</span>
                        </div>
                        <div className="col-4 text-center">
                            <img className="img-fluid" src={TakenSeat}
                                 style={{transform: 'rotate(180deg)', maxWidth: '15%'}}/>
                                <span> - Taken</span>
                        </div>
                        <div className="col-4 text-center">
                            <img className="img-fluid" src={SelectedSeat}
                                 style={{transform: 'rotate(180deg)', maxWidth: '15%'}}/>
                                <span> - Selected</span>
                        </div>
                    </div>


                </div>


            </div>

            <div className="row d-flex flex-row-reverse mr-3 mt-4">
                <input type="submit" className="btn btn-lg btn-primary" style={{marginRight: '15%'}} value="Proceed to buying"/>
                <div className="center mr-3">
                    <Link to={"/schedule"} className="btn btn-secondary btn-lg">Back</Link>
                </div>
            </div>

        </div>
    );

};

export default ListSeats;