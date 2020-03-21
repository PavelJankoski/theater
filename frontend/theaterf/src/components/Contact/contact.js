import React, { useEffect } from 'react';
import BcgImage from "../../images/curtain.jpg";
const Contact = () => {

    useEffect(() => {
        // Update the document title using the browser API
        document.title = `Theater | Contact`;
    }, []);

    return(
        <div style={{backgroundImage: `url(${BcgImage})`, backgroundSize: '100% 100%'}}>
            <div style={{textAlign: 'center', padding: '240px 14% 90px 14%', textTransform: 'uppercase'}}>
                <h2 className="naslov">
                    Get in touch!</h2>
            </div>

            <div style={{padding: '0 14% 50px 14%'}}>
                <div className="row">
                    <div className="col-12 col-lg-4 d-flex justify-content-center" style={{textAlign: 'center'}}>
                        <div className="row">
                            <div className="col-12"><i className="fa fa-map-marker fa-5x socIc"></i></div>
                            <div className="col-12"><h3 style={{textTransform: 'uppercase'}}>Address</h3>
                                <p>6950 S. Jordan Road
                                    Centennial, CO 80112</p></div>
                        </div>


                    </div>
                    <div className="col-12 col-sm-6 col-lg-4 d-flex justify-content-center" style={{textAlign: 'center'}}>
                        <div className="row">
                            <div className="col-12"><i className="fa fa-phone-square fa-5x socIc"></i></div>
                            <div className="col-12"><h3 style={{textTransform: 'uppercase'}}>Phone</h3>
                                <p>(+389)72/213-325</p></div>
                        </div>


                    </div>
                    <div className="col-12 col-sm-6 col-lg-4 d-flex justify-content-center" style={{textAlign: 'center'}}>
                        <div className="row">
                            <div className="col-12"><i className="fa fa-envelope-square fa-5x socIc"></i></div>
                            <div className="col-12"><h3 style={{textTransform: 'uppercase'}}>email</h3>
                                <p>paveljankoski@theater.com</p></div>
                        </div>


                    </div>
                </div>


            </div>

        </div>
    )
}
export default Contact;