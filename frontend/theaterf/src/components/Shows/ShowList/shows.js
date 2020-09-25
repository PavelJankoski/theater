import React, {useEffect} from 'react';
import ShowCard from "../ShowCard/showCard";
import SearchForm from "../SearchForm/searchForm";
import axios from "axios";
import {Link} from 'react-router-dom';
import ReactPaginate from 'react-paginate';

const ListShows =(props)=>{

    useEffect(()=>{
        document.title = `Theater | Shows`;
        props.showsPaged(0);
        return()=>{
            props.refreshShows();
        }

    }, []);


    const allShows = props.showsA.map((show, index) => {
        return (
            <ShowCard show={show} showId={show.id} key={index} onDelete={props.onDelete}/>
        );
    });

    const handlePageClick = (e) => {

        props.showsPaged(e.selected)
    }

    const paginate = () => {
        if (props.totalPages !== 0) {
            return (
                <ReactPaginate previousLabel={<i className="fa fa-caret-left"></i>}
                               nextLabel={<i className="fa fa-caret-right"></i>}
                               breakLabel={<span className="gap">...</span>}
                               breakClassName={"break-me"}
                               pageCount={props.totalPages}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               pageClassName={"page-item"}
                               pageLinkClassName={"page-link"}
                               previousClassName={"page-item"}
                               nextClassName={"page-item"}
                               previousLinkClassName={"page-link"}
                               nextLinkClassName={"page-link"}
                               forcePage={props.page}
                               onPageChange={handlePageClick}
                               containerClassName={"pagination justify-content-center"}
                               activeClassName={"active"}/>
            )
        }
    }

    return (
        <div className="bcg pb-5 pt-2 pb-2">
            <div className="row mt-2 mb-2">
                <div className="col-12 col-sm-12 col-md-6 col-lg-6" style={{textAlign: 'center', paddingTop: '35px'}}>
                    <h2 className="naslov">FEAUTURED SHOWS</h2>
                </div>
                <div id="cover" className="col-12 col-sm-12 col-md-6 col-lg-6">
                    <SearchForm onSearch={props.searchShow}/>
                </div>

            </div>
            <div className="cards mt-2">

                {allShows}

            </div>
           {paginate()}


            <div className="row d-flex flex-row-reverse mt-4" style={{marginRight: '12%'}}>
                <Link id="createShowButton" to={"/shows/add"} className="btn btn-lg btn-primary" style={{padding:'10px 25px 10px 22px', fontSize:'1.3em'}}><i className="fa fa-plus"></i> Create
                    Show</Link>
            </div>

        </div>

    )
};
export default ListShows;