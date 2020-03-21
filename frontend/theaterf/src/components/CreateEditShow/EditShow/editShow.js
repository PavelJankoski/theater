import React, {useEffect, useState} from "react";
import {Link, useHistory, useParams} from 'react-router-dom';
import $ from 'jquery';
import '../../../../node_modules/popper.js/dist/popper.min';
import '../../../../node_modules/bootstrap/dist/js/bootstrap.min';
import axios from "axios";

const EditShow=(props)=>{
    const {showId} = useParams();
    const [show, setShow] = useState({});

    const todayDate = new Date().toLocaleDateString().split("/");
    const year = todayDate[2];
    const month = todayDate[0].length !== 1 ? todayDate[0] : ("0" + todayDate[0]);
    const day = todayDate[1].length !== 1 ? todayDate[1] : ("0" + todayDate[1]);
    const history = useHistory();


    useEffect(()=>{
        document.title = `Theater | Edit`;
        axios.get("http://localhost:8080/shows/" + (showId)).then(res=>{
            setShow(res.data);
            setValue(res.data);

        });

    }, [])


    function setValue(show){
            const dateAndTime = show.from.toString().split("T");
            const time = dateAndTime[1].split(":");
            $('#showTitle').val(show.title);
            $('#showDescription').val(show.description);
            $('#showDirector').val(show.title);
            $('#showSetDesigner').val(show.setDesigner);
            $('#showCostumeDesigner').val(show.setDesigner);
            $('#showFrom').val(dateAndTime[0]);
            $('#showTime').val(time[0] + ":" + time[1]);
            $('#showDuration').val(show.duration);
            $('#showScene').val(show.scene.id);
            for(let i = 0 ;i<show.actors.length;i++){
                $(":checkbox[value=" + show.actors[i].id +"]").prop("checked","true");
            }
    }

    const getActors = props.actors.map((actor, idx) =>{
        return(
            <div className="checkbox" key={actor.id} actorid={actor.id}>
                <label><input type="checkbox" name={"actor"} value={actor.id} style={{marginRight: '7px'}}/>{actor.name} {actor.surname}
                    <a onClick={()=>props.onDeleteActor(actor.id)} className="btn btn-danger btn-sm" style={{marginLeft:'15px'}}><i className="fa fa-trash" style={{color:'white'}}></i></a>
                </label>
            </div>
        );

    });

    const getScenes = props.scenes.map((scene, idx) =>{
        return(
            <option key={scene.id} sceneid={scene.id} value={scene.id}>{scene.name} ({scene.capacity})</option>
        );
    });


    const onFormSubmitShow =(e) =>{
        e.preventDefault();
        const checkedActrs =[];
        const checkboxes = document.getElementsByName("actor");
        for(let i=0;i<checkboxes.length;i++){
            if(checkboxes[i].checked){
                checkedActrs.push(parseInt(checkboxes[i].value));
            }
        }

        const rlactors=[];
        for(let i = 0;i<props.actors.length;i++){
            for(let j =0;j<checkedActrs.length;j++){
                if(props.actors[i].id===checkedActrs[j]){
                    rlactors.push(props.actors[i]);
                    break;
                }
            }
        }

        const ez = document.getElementById("showScene");
        const selScene = parseInt(ez.options[ez.selectedIndex].value);
        let scn = {};
        for(let i = 0;i<props.scenes.length;i++){
            if(props.scenes[i].id === selScene){
                scn=props.scenes[i];
                break;
            }
        }


        const editedShow ={
            "title": e.target.title.value,
            "description": e.target.description.value,
            "director": e.target.director.value,
            "setDesigner": e.target.setDesigner.value,
            "costumeDesigner": e.target.costumeDesigner.value,
            "from": e.target.date.value + "T" + e.target.time.value +":00",
            "duration": e.target.duration.value,
            "actors": rlactors,
            "scene": scn
        };

        debugger;
        props.onShowUpdated(showId, editedShow);

        history.push("/shows");
    };

    const onFormSubmitActor =(e) =>{
        e.preventDefault();
        const newActor={
            "name": e.target.actorName.value,
            "surname": e.target.actorSurname.value,
        };
        props.onNewActorAdded(newActor);
        $("#createActor").modal('hide');
        $('.modal-backdrop').remove();
        $('#actorName').val("");
        $('#actorSurname').val("");
        history.push("/shows/" + showId + "/edit");
    };



    const onFormSubmitScene =(e) =>{
        e.preventDefault();
        const newScene={
            "name": e.target.sceneName.value,
            "capacity": e.target.sceneCapacity.value,
            "seatsInRow": e.target.seatsInRow.value
        };
        props.onNewSceneAdded(newScene);
        $("#createScene").modal('hide');
        $('.modal-backdrop').remove();
        $('#sceneName').val("");
        $('#sceneCapacity').val("");
        history.push("/shows/" + showId + "/edit");
    };

    return(
        <div>
            <div className="bcg" style={{padding: '6%'}}>
                <div className="row">
                    <div className="col-12 col-sm-12 col-md-6 col-lg-6"
                         style={{textAlign: 'center', paddingBottom: '30px', textTransform: 'uppercase'}}>
                        <h2 className="naslov">
                            Edit show</h2>
                    </div>
                </div>

                <form className="form-group" onSubmit={onFormSubmitShow}>
                        <label htmlFor="showTitle">Show Title:</label>
                        <input type="text" name={"title"} className="form-control" id="showTitle" placeholder="Enter Show title here..."/>

                        <label htmlFor="showDescription">Show Description:</label>
                        <textarea placeholder="Enter Show description here..." className="form-control" name={"description"} id="showDescription" rows="3"
                                  style={{maxHeight: '150px', minHeight:'100px', overflowY: 'scroll'}}></textarea>
                    <div className="row">
                        <div className="col-12 col-lg-6">
                                <label htmlFor="showDirector">Director:</label>
                                <input type="text" name={"director"} className="form-control" id="showDirector"
                                       placeholder="Enter Show Director here..."/>
                        </div>
                        <div className="col-6 col-lg-3">
                                <label htmlFor="showSetDesigner">Set Designer:</label>
                                <input type="text" name={"setDesigner"} className="form-control" id="showSetDesigner"
                                       placeholder="Enter Set Designer here..."/>
                        </div>
                        <div className="col-6 col-lg-3">

                                <label htmlFor="showCostumeDesigner">Costume Designer:</label>
                                <input type="text" name={"costumeDesigner"} className="form-control" id="showCostumeDesigner"
                                       placeholder="Enter Costume designer here..."/>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-12">
                            <span>Actors:</span>
                        </div>
                        <div className="col-12">
                            <div className="row">
                                <div className="col-10">
                                    <div className="checkbox-list"
                                         style={{padding:'2% 0 2% 2%', margin:'8px 0 5% 0', border:'1px solid #444444', borderRadius: '0.5em', boxShadow: '7px 11px 29px -10px rgba(0,0,0,0.75)'}}>
                                        {getActors}
                                    </div>
                                </div>
                                <div className="col-2 text-center m-auto">
                                    <button type="button" data-toggle="modal" data-target="#createActor"
                                            className="btn btn-sm btn-primary pt-2 pr-2"
                                            style={{borderRadius: '50%', marginBottom: '20%'}}><i className="fa fa-plus fa-2x"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-10">

                                <label htmlFor="showScene">Select scene:</label>
                                <select className="form-control" name={"scene"} id="showScene">
                                    {getScenes}
                                </select>
                        </div>
                        <div className="col-2 text-center m-auto">
                            <button type="button" data-toggle="modal" data-target="#createScene"
                                    className="btn btn-sm btn-primary pt-2 pr-2 mt-3" style={{borderRadius: '50%'}}><i
                                className="fa fa-plus fa-2x"></i></button>
                        </div>
                    </div>
                    <div className="row mt-2">
                        <div className="col-sm-6 col-12 mb-3">
                            <label htmlFor="showDate">Date:</label>
                            <input type="date" className="form-control" min={year + "-" + month + "-" + day}
                                   name={"date"} id="showFrom"/>
                        </div>
                        <div className="col-lg-3 col-6">
                            <label htmlFor="showTime">Time:</label>
                            <input type="time" className="form-control" id="showTime" name={"time"}
                                   min="08:00" max="21:00"/>
                        </div>
                        <div className="col-lg-3 col-6">
                            <label htmlFor="showDuration">Duration(in minutes):</label>
                            <input type="number" className="form-control numberInput" name={"duration"} min="0"
                                   id="showDuration" placeholder="Enter Show duration..."/>
                        </div>
                    </div>
                    <div className="row d-flex flex-row-reverse mr-3">
                        <input type="submit" className="btn btn-lg btn-primary" value="Save"/>
                        <div className="center mr-3">
                            <Link to={"/shows"} className="btn btn-secondary btn-lg">Back</Link>
                        </div>
                    </div>
                </form>

                <div className="modal fade" id="createActor" tabIndex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
                     aria-hidden="true">
                    <div className="modal-dialog modal-dialog-centered" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLongTitle">Create Actor</h5>
                            </div>
                            <form className="form-group" onSubmit={onFormSubmitActor}>
                                <div className="modal-body">
                                        <label htmlFor="actorName">Actor Name</label>
                                        <input type="text" name={"actorName"} className="form-control" id="actorName" placeholder="Enter Actor name..."/>
                                        <label htmlFor="actorName">Actor surname</label>
                                        <input type="text" name={"actorSurname"} className="form-control" id="actorSurname" placeholder="Enter Actor surname..."/>
                                </div>
                                <div className="modal-footer">
                                    <button type="button" className="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button id="actorSubmit" type="submit" className="btn btn-primary">Save</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


            <div className="modal fade" id="createScene" tabIndex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
                 aria-hidden="true">
                <div className="modal-dialog modal-dialog-centered" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="sceneTitle">Create Scene</h5>
                            <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form className="form-group" onSubmit={onFormSubmitScene}>
                            <div className="modal-body">

                                    <label htmlFor="sceneName">Scene Name</label>
                                    <input type="text" name={"sceneName"} className="form-control" id="sceneName" placeholder="Enter Scene name..."/>

                                    <label htmlFor="sceneCapacity">Capacity</label>
                                    <input type="number" className="numberInput" min="0" name={"sceneCapacity"} className="form-control" id="sceneCapacity" placeholder="Enter Scene capacity..."/>

                                    <label htmlFor="seatsInRow">Seats in row</label>
                                    <input type="number" className="numberInput" max="14" min="5" name={"seatsInRow"} className="form-control" id="seatsInRow" placeholder="Enter number of seats in row.."/>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button id="sceneSubmit" type="submit" className="btn btn-primary">Save</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default EditShow;