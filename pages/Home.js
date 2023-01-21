import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link} from "react-router-dom";

export default function Home() {
  const [songs, setSongs] = useState([]);
  
  useEffect(() => {
    loadSongs();
    console.log("page loading");
  }, []);

  const loadSongs = async()=> {
    const result = await axios.get("http://localhost:8080/songs");
    console.log(result.data );
    setSongs(result.data);
  }

  const deleteSong = async(id) => {
      await axios.delete(`http://localhost:8080/songs/${id}`, songs);
      loadSongs();
  }

  return (
    <>
      <div className="container">
        <div className="py-4">
          <table className="table">
              <thead>
                <tr>
                  <th scope="col">SNo.</th>
                  <th scope="col">Song ID</th>
                  <th scope="col">Song Name</th>
                  <th scope="col">Singer ID</th>
                  <th scope="col">Singer Name</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                {
                  songs.map((song, index) => (
                    <tr>
                      <th scope="row" key={index}>{index+1}</th>
                      <td>{song.songID}</td>
                      <td>{song.songName}</td>
                      <td>{song.singer.singerID}</td>
                      <td>{song.singer.singerName}</td>
                      <td>
                        <Link className="btn btn-primary mx-2" to={`/viewsong/${song.songID}`}> View </Link>
                        <Link className="btn btn-outline-primary mx-2" to={`/editsong/${song.songID}`}> Edit </Link>
                        <button className="btn btn-danger mx-2" onClick={() => deleteSong(song.songID)}> Delete </button>
                      </td>
                    </tr>
                  ))
                }
                
              </tbody>
            </table>
        </div>
    </div>
    </>
                  
  );

}
