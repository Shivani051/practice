import axios from 'axios';
import React from 'react'
import { useEffect } from 'react';
import { useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';

export default function EditSong() {

    let navigate = useNavigate();
    const {id} = useParams();

    const [song, setSong] = useState({
        songID:"",
        songName:"",
        singer:{
            singerID:"",
            singerName:""
        },
    }); 

    const onInputChange=(e)=> {
        setSong({...song, [e.target.name]: e.target.value});
    };

    const onSingerInputChange=(e)=> {
        setSong({
            ...song, singer:{
                ...song.singer, [e.target.name]: e.target.value
            }
        });
    }

    useEffect(()=>{
        loadSong()
    },[]);

    const loadSong = async ()=>{
        const result = await axios.get(`http://localhost:8080/songs/${id}`)
        setSong(result.data);
    }

    const onSubmit= async(e)=> {
        e.preventDefault();
        await axios.put(`http://localhost:8080/songs/${id}`, song);
        navigate("/");
    }

    return(
        <div className='container'>
                <div className='row'>
                    <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                        <h2 className='text-center m-4'> Edit Song Details</h2>

                        <form onSubmit={(e)=> onSubmit(e)}>
                            <div className="mb-3">
                                <label htmlFor='SongId' className='form-label'>
                                    Song ID
                                </label>
                                <input type={"text"} className='form-control' placeholder='Enter song id' name='songID' value={song.songID} onChange={(e)=>onInputChange(e)}/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor='SongName' className='form-label'>
                                    Song Name
                                </label>
                                <input type={"text"} className='form-control' placeholder='Enter song name' name='songName' value={song.songName} onChange={(e)=>onInputChange(e)}/>
                            </div>


                            <div className="mb-3">
                                <label htmlFor='SingerId' className='form-label'>
                                    Singer ID
                                </label>
                                <input type={"text"} className='form-control' placeholder='Enter singer id' name='singerID' value={song.singer.singerID} onChange={(e)=>onSingerInputChange(e)}/>
                            </div>

                            <div className="mb-3">
                                <label htmlFor='SingerName' className='form-label'>
                                    Singer Name
                                </label>
                                <input type={"text"} className='form-control' placeholder='Enter singer name' name='singerName' value={song.singer.singerName} onChange={(e)=>onSingerInputChange(e)}/>
                            </div>


                            <button type='submit' className='btn btn-outline-primary'> Submit</button>
                            <Link className='btn btn-outline-danger mx-2' to="/"> Cancel</Link>

                        </form>
                    </div>
                </div>
            </div>
    );

}
