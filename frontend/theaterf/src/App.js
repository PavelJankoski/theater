import React, {useState, useEffect, useRef} from 'react';
import "./all.css";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Navbar from "./components/Navbar/navbar";
import Footer from "./components/Footer/footer";
import Contact from "./components/Contact/contact";
import Shows from "./components/Shows/ShowList/shows";
import HomeCarousel from "./components/HomeShowCarousel/Carousel/carousel";
import axios from 'axios';
import ScheduleList from "./components/Schedule/ScheduleList/scheduleList";
import ShowDetails from "./components/ShowDetails/showDetails";
import CreateShow from "./components/CreateEditShow/CreateShow/createShow";
import EditShow from "./components/CreateEditShow/EditShow/editShow";
import ShowsService from "./repository/axiosShowsRepository";
import ListSeats from "./components/SelectSeats/ListSeats/listSeats";

function App() {

    const [shows, setShows] = useState([]);
    const [actors, setActors] = useState([]);
    const [scenes, setScenes] = useState([]);
    const [activeIndex, setActiveIndex] = useState(0);
    const [pageSize, setPageSize] = useState(6);
    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState(0);



    useEffect(() => {
        // listShowsPaged();
        listShows();
        listActors();
        listScenes();
    }, []);


    const listShowsPaged = (page=0)=>{
        ShowsService.fetchShowsPaged(page, pageSize).then((data)=>{
             setShows(data.data.content);
             setPage(data.data.page);
             setTotalPages(data.data.totalPages);
        })
    }

    const listShows = () =>{
        axios.get("http://localhost:8080/shows").then(res =>{
            setShows(res.data)
        });
    };
    const listActors = () =>{
        axios.get("http://localhost:8080/actors").then(res=>{
            setActors(res.data)
        });
    };
    const listScenes = () =>{
        axios.get("http://localhost:8080/scenes").then(res=>{
            setScenes(res.data)
        });
    };
    const searchShow = (searchTerm)=>{
        axios.get("http://localhost:8080/shows?term=" + (searchTerm)).then(res => {
            setShows(res.data);
            setTotalPages(0);
        });
    }


    const setImage = (formDatas, newShowId) =>{
        axios({
            url: 'http://localhost:8080/shows/' + newShowId + '/image',
            method: 'POST',
            data: formDatas
        }).then(()=>{
            listShowsPaged();
        });

    };




    const createActor = (newActor) =>{
        axios.post("http://localhost:8080/actors", newActor, {headers:{
            'Content-Type':"application/json"
            }}).then((resp)=>{
                setActors([...actors,resp.data])
        })
    };

    const createScene = (newScene) =>{
        axios.post("http://localhost:8080/scenes", newScene, {headers:{
                'Content-Type':"application/json"
            }}).then((resp)=>{
            setScenes([...scenes,resp.data])
        })
    };


    const updateShow=(showId, show)=>{
        debugger;
        axios.put("http://localhost:8080/shows/" + (showId), show, {}).then(()=>{
            listShowsPaged();
        })
    }

    const deleteShow = (showId) =>{
        debugger;
        axios.delete("http://localhost:8080/shows/" + (showId)).then(()=>{
            listShowsPaged();
        })
    };

    const deleteActor = (actorId) =>{
      const newActors = actors.filter((a) =>{
          return a.id!==actorId
      });
        axios.delete("http://localhost:8080/actors/" + (actorId)).then(res =>{
            setActors(newActors);
        })
    };



  return (
    <div className="App">

      <Router>
          <Navbar/>
          <Route path={"/"} exact render={()=>
              <HomeCarousel showsC={shows} activeIndex={activeIndex}/>}>
          </Route>
        <Route path={"/shows"} exact render={()=>
            <Shows showsA={shows} onDelete={deleteShow} searchShow={searchShow} showsPaged={listShowsPaged} page={page} totalPages={totalPages} refreshShows={listShows}/>}>
        </Route>
          <Route path={"/shows/add"} exact render={()=>
              <CreateShow scenes={scenes} actors={actors} slika={setImage} onNewActorAdded={createActor} onNewSceneAdded={createScene} onDeleteActor={deleteActor} />}>
          </Route>
          <Route path={"/shows/:showId/edit"} exact render={()=>
              <EditShow scenes={scenes} actors={actors} onShowUpdated={updateShow} onNewActorAdded={createActor} onNewSceneAdded={createScene} onDeleteActor={deleteActor} />}>
          </Route>
          <Route path={"/shows/:showId/details"} exact render={()=>
              <ShowDetails shows={shows} refreshShows={listShowsPaged} onDelete={deleteShow}/>}>
          </Route>
          <Route path={"/schedule/:showId/seats"} exact render={()=>
              <ListSeats/>}>
          </Route>
          <Route path={"/schedule"} exact render={()=>
              <ScheduleList shows={shows}/>}>
          </Route>
        <Route path={"/contact"} exact render={()=>
        <Contact/>}>
        </Route>
          <Redirect to={"/"}/>
      </Router>

        <Footer/>

    </div>
  );
}

export default App;
