import React from "react";


const Footer = () => {
    return(
        <footer className="page-footer font-small pt-4 position-sticky">
            <div className="container-fluid padding">


                <div className="socialMedia">


                    <a href="https://www.facebook.com/">
                        <i className="fab fa-facebook-square fa-3x mr-4"></i>
                    </a>

                    <a href="https://www.twitter.com">
                        <i className="fab fa-twitter-square fa-3x mr-4"></i>
                    </a>


                    <a href="https://www.instagram.com">
                        <i className="fab fa-instagram fa-3x mr-4"></i>
                    </a>

                    <a href="https://www.pinterest.com">
                        <i className="fab fa-pinterest-square fa-3x"></i>
                    </a>

                </div>
            </div>



            <div className="footer-copyright text-center py-4">©2020 Copyright: <span
                style={{fontWeight: 'bold' }}>Theater</span>. All
                Rights Reserved
            </div>
        </footer>
    )
}
export default Footer;