import React from "react";
import Logo from "../../../images/logo-without-text.jpg";
import Moment from "react-moment";
import {Link} from "react-router-dom";

const ScheduleCard = (props) =>{
    const showImage = 'data:image/jpeg;base64,'+props.show.image;

    return(
        <div className="p-3"
             style={{backgroundColor: 'rgb(254,242,236)', borderWidth: '1px 1px 5px 1px', borderColor: '#444444', borderStyle: 'solid'}}>
            <div className="p-3"
                 style={{borderWidth: '0 0 1px 4px', borderColor: 'rgb(40,68,79)', borderStyle: 'solid'}}>
                <div style={{color: '#444444', fontSize: '16px', marginBottom: '6px'}}>
                    <Moment format="DD MMMM YYYY">
                        {props.show.from}
                    </Moment>
                     <span> from </span>
                    <Moment format="HH:mm">
                        {props.show.from}
                    </Moment>

                </div>
                <div className="row">
                    <img className="col-12 col-md-4" style={{width: 'auto', height: '140px'}}
                         src={showImage}
                         alt={props.show.title}/>
                        <div className="col-12 col-md-5 mt-4"
                             style={{paddingLeft: '20px', color: '#444444', fontSize: '16px'}}>
                            <img style={{width: '30px', display: 'inline-block', marginRight: '5px'}} src={Logo}/>
                                <p style={{display:'inline-block', position: 'relative', top:'5px', fontSize: '25px', textTransform: 'capitalize', fontWeight: 'bold'}}>
                                       {props.show.title}</p>
                                <p style={{marginBottom: '4px !important'}}><span style={{fontWeight: 'bold'}}>Duration:</span> {props.show.duration} minutes</p>

                                    {/*<Moment diff={Date.now()} unit="days">{props.show.from}</Moment>*/}

                            <p><span style={{fontWeight: 'bold'}}>Location:</span> {props.show.scene.name}</p>
                        </div>
                        <div className="col-12 col-md-3" style={{alignSelf: 'center'}}>
                            <div className="row pl-3 pr-3">
                                <Link to={"shows/" + props.showId + "/details"} className="btn btn-md btn-primary mt-3 p-2 col-5 col-md-12" href="#"
                                   style={{textAlign: 'center', whiteSpace: 'nowrap'}}>View show</Link>
                                <Link to={"/schedule/" + props.showId + "/seats"} className="btn btn-md  btn-primary mt-3 p-2 ml-auto col-5 col-md-12"
                                   style={{textAlign: 'center', whiteSpace: 'nowrap'}}><i
                                    className="fa fa-shopping-cart"/> Buy
                                    tickets</Link>


                            </div>
                        </div>
                </div>

            </div>
        </div>
    );
}
export default ScheduleCard;