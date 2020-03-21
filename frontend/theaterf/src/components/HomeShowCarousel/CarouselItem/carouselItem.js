import React from "react";
import {Link} from "react-router-dom";
const CarouselItem =(props)=>{
    const showImage = 'data:image/jpeg;base64,'+props.show.image;
    return(
        <div className={"carousel-item " + (props.activeIndex === props.index ? "active" : "")}>
            <Link to={"/shows"}><img
                src={showImage}
                className="d-block w-100" alt={props.show.title}/></Link>
            <div className="carousel-caption">
                <h2 className="animated fadeInDown pb-3">{props.show.title}</h2>

                <Link to={"shows/" + props.show.id + "/details"} className="btn btn-primary btn-lg animated fadeInUp">Open Show</Link>

            </div>
        </div>
    );
}

export default CarouselItem;