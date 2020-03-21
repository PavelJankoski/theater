import React from 'react';
import Logo from "../../images/logo2.jpg";
import {Link, NavLink} from "react-router-dom";
import $ from 'jquery';

const Navbar = () => {

const collapseNav = ()=>{
    if($(window).width()<768){
        $('.navbar-collapse').collapse('toggle');
    }

};



    return (

            <nav className="navbar navbar-expand-md navbar-light bg-light sticky-top">
                <div className="container-fluid">
                    <Link to={"/"} className="navbar-brand"><img src={Logo} alt="theater logo"/></Link>
                    <button className="navbar-toggler" onClick={()=>collapseNav()} type="button">
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    <div className="collapse navbar-collapse" id="theaterNav">
                            <ul className="navbar-nav ml-auto">
                                <li className="nav-item">
                                    <NavLink onClick={()=>collapseNav()} exact className="nav-link" to={"/"} >Home</NavLink>
                                </li>
                                <li className="nav-item">
                                    <NavLink onClick={()=>collapseNav()} className="nav-link" to={"/shows"}>Shows</NavLink>
                                </li>

                                <li className="nav-item">
                                    <NavLink onClick={()=>collapseNav()} className="nav-link" to={"/schedule"}>Schedule</NavLink>
                                </li>
                                <li className="nav-item">
                                    <NavLink onClick={()=>collapseNav()} className="nav-link" to={"/contact"}>Contact</NavLink>
                                </li>

                                <li className="nav-item">
                                    <Link onClick={()=>collapseNav()} className="nav-link hoverableBox" to={"/schedule"}>Buy tickets</Link>
                                </li>
                            </ul>

                    </div>
                </div>
            </nav>



    )
}
export default Navbar;