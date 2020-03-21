import React from "react";
import {Link} from "react-router-dom";


const showCard =(props)=>{
    const showImage = 'data:image/jpeg;base64,'+props.show.image;
    return(
        <div className="containerC"
             style={{backgroundImage: `url(${showImage})`, backgroundSize: '100% 100%'}}>
            <div className="overlay">
                <div className="items"></div>
                <div className="items head">
                    <p>{props.show.title}</p>
                    <hr/>
                </div>
                <div className="items descriptionC">

                    <p>{props.show.description}</p>
                </div>
                <div className="items cardFooter">
                    <Link to={"shows/" + props.showId + "/details"} className="btn btn-sm btn-primary mb-4 p-2" style={{fontSize: '1.3em'}}>More
                        details <i className="fa fa-angle-double-right"></i></Link>
                    <Link to={"shows/" + props.showId + "/edit"} className="btn btn-sm btn-primary" style={{fontSize: '27px', margin: '0 6px 23px 90px'}}><i
                        className="fa fa-edit"></i> </Link>
                    <a onClick={()=>props.onDelete(props.showId)} className="btn btn-sm delete" style={{fontSize: '27px', marginBottom: '23px'}}><i
                        className="fa fa-trash"></i> </a>
                </div>
            </div>
        </div>
    );
}
export default showCard;