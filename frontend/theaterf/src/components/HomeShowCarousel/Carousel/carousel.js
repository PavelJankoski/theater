import React, {useEffect} from "react";
import CarouselItem from "../CarouselItem/carouselItem";

const HomeCarousel=(props)=>{

    useEffect(() => {
        // Update the document title using the browser API
        document.title = `Theater | Home`;
    }, []);


    const allShows = props.showsC.map((show, index) => {
        return(
            <CarouselItem show={show} index={index} activeIndex={props.activeIndex} key={index} />
        );
    });
    const indicators = props.showsC.map((show, index) => {
        return(
            <li data-target="#showCarousel" data-slide-to={index} className={props.activeIndex === index ? 'active' : ""} key={index}></li>
        );
    });


    return(

        <div id="showCarousel" className="carousel slide" data-ride="carousel">
            <ol className="carousel-indicators">
                {indicators}
            </ol>
            <div className="carousel-inner">
                {allShows}
            </div>
            <a className="carousel-control-prev" href="#showCarousel" role="button" data-slide="prev">
                <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                <span className="sr-only">Previous</span>
            </a>
            <a className="carousel-control-next" href="#showCarousel" role="button" data-slide="next">
                <span className="carousel-control-next-icon" aria-hidden="true"></span>
                <span className="sr-only">Next</span>
            </a>
        </div>
    );
}




export default HomeCarousel;