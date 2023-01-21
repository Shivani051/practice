import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layout/Navbar";
import Home from "./pages/Home";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import AddSong from "./songs/AddSong";
import EditSong from "./songs/EditSong";
import ViewSong from "./songs/ViewSong";

function App() {
  return (
    <div className="App">
        <Router>
          <Navbar />
          <Routes>
            <Route exact path="/" element={<Home/>} />
            <Route exact path="/add-song" element={<AddSong/>} />
            <Route exact path="/editsong/:id" element={<EditSong/>} />
            <Route exact path="/viewsong/:id" element={<ViewSong/>}/>
          </Routes>
        </Router>
        
    </div>
  );
}

export default App;
