import React, {useEffect, useState} from "react";
import {useParams, Link, useHistory} from "react-router-dom";
import axios from "axios";
import Moment from "react-moment";
import Rating from 'react-rating';

const ShowDetails =(props) =>{
    const {showId} = useParams();
    const [show, setShow] = useState({});
    const [actors, setActors] = useState([]);
    const history = useHistory();

    useEffect(()=>{
        axios.get("http://localhost:8080/shows/" + (showId)).then(res=>{
            const show = res.data;
            const newShow={
                ...show,
                "sceneName":show.scene.name,

            }
            setShow(newShow);
            setActors(res.data.actors);

        });


    }, [])



    return(
        <div className="bcg" style={{padding: '80px 60px 80px 60px'}}>
            <div className="row">
                <img className="col-xl-6"
                     src={'data:image/jpeg;base64,'+show.image}
                     alt={show.title}/>

                    <div className="col-xl-6 details" style={{paddingLeft: '4%', paddingTop: '3%'}}>

                        <div className="row">
                            <div className="col-12">
                                <div className="row float-right" style={{marginTop: '17px', marginRight: '10px'}}>
                                    <Link to={"/shows/" + (showId) + "/details"} className="btn btn-sm btn-primary float-right"
                                       style={{fontSize: '27px', marginRight: '10px'}}><i className="fa fa-edit"></i> </Link>
                                    <Link to={"/shows"} onClick={()=> {props.onDelete(showId); history.push("/shows");}} className="btn btn-sm delete float-right" style={{fontSize: '27px'}}><i
                                        className="fa fa-trash"></i> </Link>

                                </div>
                            </div>
                            <div className="col-12">
                                <div className="row">
                                    <div className="col-7">
                                        <h2 style={{fontWeight: '800', fontSize: '2.8em', clear: 'left'}}>{show.title}</h2>
                                    </div>
                                    <div  className="col-5 m-auto text-center" style={{paddingTop:'10px'}}>

                                            <div id="starRating">
                                                <Rating
                                                    emptySymbol="fa fa-star-o fa"
                                                    fullSymbol="fa fa-star fa"
                                                />
                                                <div id="ratingText">(4.5/5) out of 20 rating(s)</div>
                                            </div>



                                    </div>
                                </div>
                            </div>


                        </div>


                        <hr style={{paddingBottom: '8%', borderTop: '2px solid #555555'}}/>
                            <div className="row">
                                <div className="col-12">
                                    <div className="row">
                                        <div className="col-xl-7 col-12">
                            <span className="showDetailNames"
                                  style={{position: 'relative', bottom: '20px'}}>Director: </span><span
                                            style={{position: 'relative', bottom: '20px', whiteSpace: 'nowrap'}}>{show.director}</span>
                                            <br/>

                                                <span className={"showDetailNames " + (show.setDesigner===""?"d-none" : "")}>Set Designer: </span><span
                                            style={{whiteSpace: 'nowrap'}}>{show.setDesigner}</span>


                                                <br/>
                                                    <span className={"showDetailNames " + (show.setDesigner===""?"d-none" : "")}>Costume Designer: </span><span
                                                    style={{whiteSpace: 'nowrap'}}>{show.costumeDesigner}</span>
                                                    <br/>
                                                        <div className="row">
                                                            <div className="col-6">
                                                                <span
                                                                    className="showDetailNames">Duration: </span><span>
                                                                {/*<Moment diff={show.from} unit="minutes">{show.to}</Moment>*/}
                                                                {show.duration}
                                                            </span>
                                                            </div>
                                                            <div className="col-6 mb-3">
                                                                <span className="showDetailNames">Scene: </span><span
                                                                style={{whiteSpace: 'nowrap'}}>{show.sceneName}</span>
                                                            </div>
                                                        </div>
                                        </div>
                                        <div className="col-xl-5 col-12 mb-3">
                                            <div className="panel panel-primary">
                                                <div className="card-header"
                                                     style={{padding:'0.45rem!important', textAlign: 'center', backgroundColor: 'rgb(40,68,79)', color: 'white', fontSize: '1.3em'}}>
                                                    Actors
                                                </div>
                                                <ul className="list-group" style={{maxHeight: '147px', overflowY: 'scroll'}}>
                                                    {actors.map((actor, index) => {
                                                            return (
                                                                <li key={actor.id} className="list-group-item">{actor.name} {actor.surname}</li>
                                                            );
                                                        })}
                                                </ul>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div className="col-12 mt-4">
                                    <div className="card">
                                        <div className="card-header"
                                             style={{padding:'0.45rem!important', textAlign: 'center', backgroundColor: 'rgb(40,68,79)', color: 'white', fontSize: '1.3em'}}>
                                            Description
                                        </div>
                                        <div className="card-body">
                                            <p>{show.description}</p>

                                        </div>
                                    </div>
                                    <div className="row justify-content-end mt-4">
                                        <Link to={"/shows"}
                                                style={{verticalAlign: 'middle'}}
                                                type="button" className="btn btn-secondary btn-lg">Back
                                        </Link>

                                        <a className="nav-link hoverableBox ml-3 mr-3" href="selectSeats.html"
                                           style={{border:'1px solid rgb(250,189,100)', color: 'rgb(40,68,79)',  textAlign: 'center', borderRadius: '.25rem', transition: 'color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out', whiteSpace: 'nowrap'}}>Reserve</a>


                                    </div>
                                </div>

                            </div>


                    </div>
            </div>
        </div>
    );
}

export default ShowDetails;