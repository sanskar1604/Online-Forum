import { useEffect, useState } from "react";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";

import { Bar } from "react-chartjs-2";
ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);
const options = {
  indexAxis: "y",
  elements: {
    bar: {
      borderWidth: 2,
    },
  },
  responsive: true,
  plugins: {
    legend: {
      position: "right",
    },
    title: {
      display: true,
      text: "HackerEarth Score and Rank",
    },
  },
};

const Horizontalchart = () => {
  const [data, setData] = useState({
    labels: [],
    datasets: [
      {
        label: "",
        data: [],
        borderColor: "",
        backgroundColor: "",
      },
      {
        label: "",
        data: [],
        borderColor: "",
        backgroundColor: "",
      },
    ],
  });
  useEffect(() => {
    const fetchData = async () => {
      const url = "http://localhost:9090/mentoring";
      const labelSet = [];
      const dataSet1 = [];
      const dataSet2 = [];
      await fetch(url)
        .then((data) => {
          console.log("Api data", data);
          const res = data.json();
          return res;
        })
        .then((res) => {
          console.log("ressss", res);
          for (const val of res) {
            console.log(val.heRank);
            dataSet1.push(val.heRank);
            dataSet2.push(val.heScore);
            labelSet.push(val.name);
          }
          console.log(dataSet1);
          setData({
            labels: labelSet,
            datasets: [
              {
                label: "Hacker Earth Rank",
                data: dataSet1,
                borderColor: "rgb(255, 99, 132)",
                backgroundColor: "rgba(255, 99, 132, 0.5)",
              },
              {
                label: "Hacker Earth Score",
                data: dataSet2,
                borderColor: "rgb(53, 162, 235)",
                backgroundColor: "rgba(53, 162, 235, 0.5)",
              },
            ],
          });
          console.log("arrData", dataSet1, dataSet2);
        })
        .catch((e) => {
          console.log("error", e);
        });
    };

    fetchData();
  }, []);

  return (
    <div style={{ width: "100%", height: "50%" }}>
      {console.log("dataaaaaaaa", data)}
      <Bar data={data} options={options} />
    </div>
  );
};
export default Horizontalchart;
