import React, {useEffect} from "react";
import ScheduleCard from "../ScheduleCard/scheduleCard";
import StepsBar from "../StepsBar/stepsBar";
import Moment from "react-moment";

const ScheduleList = (props) => {


    useEffect(() => {
        // Update the document title using the browser API
        document.title = `Theater | Schedule`;
    }, []);

    const scheduledShows = props.shows.map((show, index)=>{
        const d = new Date(show.from);
        if(Date.now()<d){
        return(
            <ScheduleCard show={show} showId={show.id} key={show.id}/>
        );
            }

    })

    return (
        <div className="bcg">
            <StepsBar/>

            <div className="row">
                <div className="col-12 col-sm-12 col-md-6 col-lg-6"
                     style={{textAlign: 'center', paddingBottom: '30px'}}>
                    <h2 className="naslov">
                        TICKETS</h2>
                </div>
            </div>
            <div className="showTickets" className="container" style={{paddingBottom: '50px'}}>

                {scheduledShows}

            </div>
        </div>
    );
}
export default ScheduleList;