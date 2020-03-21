import axios from '../custom-axios/axios'


const ShowsService = {

    fetchShowsPaged:(page,pageSize)=>{
        return axios.get("/shows/paged",{
            headers: {
                'page':page,'page-size':pageSize
            }
        })
    }
}

export default ShowsService;