import React from 'react'
import { useState, useEffect } from 'react';
import { Link, useParams} from "react-router-dom";
import axios from "axios";

export default function ViewSong() {

    const [song, setSong] = useState({
        songID:"",
        songName:"",
        singer:{
            singerID:"",
            singerName:""
        },
    }); 

    const {id} = useParams();

    useEffect(() => {
        loadSongs();
    }, []);

    const loadSongs = async()=> {
        const result = await axios.get(`http://localhost:8080/songs/${id}`);
        setSong(result.data);
    }

  return (
    <div className='container'>
        <div className='row'>
            <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                <h2 className='text-center m-4'> Song Details</h2>

                <div className='card'>
                    <div className='card-header'>
                        Details of song ID : {song.songID}
                        <ul className='list-group list-group-flush'>
                            <li className='list-group-item'>
                                <b>Song Name:</b>
                                {song.songName}
                            </li>
                            <li className='list-group-item'>
                                <b>Singer ID:</b>
                                {song.singer.singerID}
                            </li>
                            <li className='list-group-item'>
                                <b>Singer Name:</b>
                                {song.singer.singerName}
                            </li>
                        </ul>
                    </div>

                </div>

                <Link className="btn btn-primary my-2" to={"/"}> Back to Home</Link>

            </div>
        </div>
    </div>

  )
}
