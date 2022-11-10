import { useNavigate } from "react-router-dom";

const GoToLogin = () => {
  const navigate = useNavigate();

  const route_ = (path) => {
    navigate(path);
  };

  return (
    <div>
      <h2>
        You donot have access to this page.
        <button
          className="btn btn-info"
          onClick={() => {
            route_("/");
          }}
        >
          Go to login
        </button>
      </h2>
    </div>
  );
};

export default GoToLogin;
